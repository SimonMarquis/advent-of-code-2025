class Day07(private val input: List<String>) {

    val start = input.first().indexOf('S')

    fun part1(): Int {
        var splits = 0
        input.drop(1).fold(setOf(start)) { acc, string ->
            val splitters = string.withIndex()
                .filter { it.value == '^' }
                .filter { it.index in acc }
                .also { splits += it.size }
            acc
                .minus(splitters.map { it.index }.toSet())
                .plus(splitters.flatMap { listOf(it.index.dec(), it.index.inc()) })
        }
        return splits
    }

    fun part2(): Long = input
        .drop(1)
        .fold(mapOf(start to 1L)) { acc, line ->
            buildMap {
                acc.forEach { (index, count) ->
                    if (line.getOrNull(index) == '^') {
                        merge(index - 1, count, Long::plus)
                        merge(index + 1, count, Long::plus)
                    } else {
                        merge(index, count, Long::plus)
                    }
                }
            }
        }.values
        .sum()

}
