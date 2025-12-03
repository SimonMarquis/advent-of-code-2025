class Day03(private val input: List<String>) {

    fun String.batteries() = map { it.digitToInt() }

    fun part1(): Int = input.sumOf {
        val batteries = it.batteries()
        val max = batteries.max()
        val maxIndex = batteries.indexOf(max)
        if (batteries.indexOf(max) != batteries.lastIndex) return@sumOf max * 10 + batteries.drop(maxIndex + 1).max()
        val (_, second) = batteries.sortedDescending().take(2)
        return@sumOf second * 10 + batteries.drop(batteries.indexOf(second) + 1).max()
    }

    fun part2(length: Int = 12): Long = input
        .map { it.batteries() }
        .map { batteries ->
            var fromIndex = 0
            var toIndex = batteries.size - length
            List(length) {
                batteries.subList(fromIndex, toIndex + 1)
                    .maxIndexed()
                    .also { (idx, _) ->
                        fromIndex += idx + 1
                        toIndex++
                    }.value
            }
        }
        .sumOf { it.produce() }

    fun Iterable<Int>.produce(): Long = fold(0L) { acc, it -> acc * 10 + it }

}
