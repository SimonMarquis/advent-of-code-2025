class Day06(private val input: List<String>) {
    val spacer = "\\s+".toRegex()
    val numbers = input.dropLast(1).map { it.trim().split(spacer).map { it.toLong() } }
    val operators = input.last().trim().split(spacer)

    fun part1(): Long = operators
        .withIndex()
        .sumOf { (i, op) ->
            numbers.map { it[i] }.compute(op.first())
        }

    fun part2(): Long = input.flip()
        .joinToString("\n") { it.joinToString("").trim() }
        .lines().splitParts("")
        .sumOf {
            it
                .map { it.dropLastWhile { !it.isDigit() }.toLong() }
                .compute(operator = it.first().last())
        }

    private fun List<Long>.compute(operator: Char) = when (operator) {
        '+' -> sum()
        '*' -> reduce(Long::times)
        else -> error(operator)
    }

    private fun List<String>.flip(): Array<CharArray> =
        Array(this[0].length) { x -> CharArray(size) { y -> this[y][x] } }

}
