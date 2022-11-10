package basics.ranges

fun useRange(input: IntProgression) {
    print('\t')
    for (x in input) {
        print("$x ")
    }
    println()
}

fun main() {
    val range1 = 1..10
    val range2 = 1..10 step 2
    val range3 = 10 downTo 1
    val range4 = 10 downTo 1 step 2
    val range5 = 1 until 10
    val range6 = 1 until 10 step 2

    val ranges = listOf(range1, range2, range3, range4, range5, range6)
    println("The values of the ranges:")
    ranges.forEach(::useRange)

    val reversedRanges = ranges.map { it.reversed() }
    println("And now in reverse:")
    reversedRanges.forEach(::useRange)
}
