import kotlin.math.max

class Day05(input: List<String>) {

    private val data = input.splitParts(delimiter = "").toPair()
    private val ranges: List<LongRange> = data.first.map { it.split("-").map(String::toLong).let { (a, b) -> a..b } }
    private val ids: List<Long> = data.second.map { it.toLong() }

    private fun LongRange.size() = max(0, last - first + 1)
    private operator fun LongRange.contains(other: LongRange): Boolean = other.first in this && other.last in this

    fun part1(): Int = ids.count { id -> ranges.any { id in it } }

    fun part2(): Long = ranges.asSequence().foldInPlace(mutableListOf<LongRange>()) { range ->
        removeAll { it in range } // Remove all wrapped ranges
        fold(range) { acc, longs ->
            when {
                (acc.first in longs) -> ((longs.last + 1)..acc.last)
                (acc.last in longs) -> (acc.first..<longs.first)
                else -> acc
            }
        }.takeUnless(LongRange::isEmpty)?.let(::add)
    }.sumOf { it.size() }

}
