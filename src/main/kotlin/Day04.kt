class Day04(private val input: List<String>) {

    private val world = input.toWorld()
    private fun List<String>.toWorld(): Array<CharArray> =
        Array(size) { x -> CharArray(this[x].length) { y -> this[x][y] } }

    private fun Array<CharArray>.walk(): Sequence<Pair<Int, Int>> =
        indices.asSequence().flatMap { x -> get(x).indices.asSequence().map { y -> x to y } }

    private operator fun Array<CharArray>.get(it: Pair<Int, Int>) = getOrNull(it.first)?.getOrNull(it.second)
    private operator fun Array<CharArray>.set(it: Pair<Int, Int>, value: Char) = this[it.first].set(it.second, value)

    private fun Pair<Int, Int>.isRoll() = world[this] == '@'
    private fun Pair<Int, Int>.isAccessible() = neighbours().count { it.isRoll() } < 4
    private fun Pair<Int, Int>.remove() = world.set(this, '.')

    private fun Pair<Int, Int>.neighbours(): List<Pair<Int, Int>> = listOf(
        /*↑*/ first /**/ to second - 1,
        /*↗*/ first + 1 to second - 1,
        /*→*/ first + 1 to second, /**/
        /*↘*/ first + 1 to second + 1,
        /*↓*/ first /**/ to second + 1,
        /*↙*/ first - 1 to second + 1,
        /*←*/ first - 1 to second, /**/
        /*↖*/ first - 1 to second - 1,
    )

    fun part1(): Int = world.walk()
        .filter { it.isRoll() }
        .count { it.isAccessible() }

    fun part2(): Int {
        var count = 0
        val rolls = world.walk()
            .filter { it.isRoll() }
            .toMutableList()
        while (true) {
            rolls
                .filter { it.isAccessible() }
                .ifEmpty { return count }
                .onEach { it.remove(); count++ }
                .also { rolls.removeAll(it) }
        }
    }
}
