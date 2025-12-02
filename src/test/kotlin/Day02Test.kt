import Resources.readText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 02")
class Day02Test {

    private val sampleInput = readText("Day02-sample.txt")
    private val actualInput = readText("Day02.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() =
            assertEquals(
            expected = 1227775554,
            actual = Day02(sampleInput).part1(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 17077011375,
            actual = Day02(actualInput).part1(),
        )

    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() = assertEquals(
            expected = 4174379265,
            actual = Day02(sampleInput).part2(),
        )

        @Test
        fun `Actual answer`() = assertEquals(
            expected = 36037497037,
            actual = Day02(actualInput).part2(),
        )

    }

}