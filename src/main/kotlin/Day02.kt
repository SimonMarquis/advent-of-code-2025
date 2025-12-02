class Day02(input: String) {

    private val ids: List<LongRange> = input.split(",")
        .map {
            it.split("-")
                .map(String::toLong)
                .let { (l, r) -> l..r }
        }

    fun part1(): Long = ids.flatten()
        .filter { it.isInvalidPart1() }
        .sum()

    fun Long.isInvalidPart1(): Boolean = toString().let {
        if (it.length % 2 != 0) return false
        val middle = it.length / 2
        for (i in 0 until middle) {
            if (it[i] != it[middle + i]) return false
        }
        return true
    }

    fun part2(): Long = ids.flatten()
        .filter { it.isInvalidPart2() }
        .sum()

    fun Long.isInvalidPart2(): Boolean = toString().let {
        val middle = it.length / 2
        for (s in 1..middle) {
            if (it.chunked(s).distinct().size == 1) return true
        }
        return false
    }

}
