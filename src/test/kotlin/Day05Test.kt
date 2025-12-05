import Resources.readLines
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 05")
class Day05Test {

    private val sampleInput = readLines("Day05-sample.txt")
    private val actualInput = readLines("Day05.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 3,
            actual = Day05(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 529,
            actual = Day05(actualInput).part1(),
        )

    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 14,
            actual = Day05(sampleInput).part2(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 344260049617193,
            actual = Day05(actualInput).part2(),
        )

    }

}