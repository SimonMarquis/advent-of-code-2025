class Day01(private val input: List<String>) {

    fun part1(): Int {
        var count = 0
        var dial = 50L
        input.forEach {
            val amount = it.substring(1).toLong()
            when (it.first()) {
                'L' -> dial -= amount
                'R' -> dial += amount
            }
            dial %= 100
            if (dial == 0L) count++
        }
        return count
    }

    fun part2(): Int {
        var count = 0
        var dial = 50
        input.forEach {
            val amount = it.substring(1).toInt()
            when (it.first()) {
                'L' -> {
                    dial += amount
                    count += dial / 100
                }

                'R' -> {
                    if (dial == 0) count--
                    dial -= amount
                    count += (-dial + 100) / 100
                }
            }
            dial = dial.mod(100)

        }
        return count
    }

}
