package hello

import java.util.Scanner

fun main() {
    val numbers = mutableListOf<Int>()
    val scanner = Scanner(System.`in`)
    val endOfInput = Regex("[X]{3}")
    println("Enter some numbers or three 'X' to finish")

    while (scanner.hasNextLine()) {
        if (scanner.hasNextInt()) {
            numbers += scanner.nextInt()
        } else {
            if (scanner.hasNext(endOfInput.toPattern())) {
                break
            } else {
                val mysteryText = scanner.nextLine()
                println("Ignoring $mysteryText")
            }
        }
    }
    //show support for FP
    val total1 = numbers.fold(0, Int::plus)
    println("Total of numbers is: $total1")
    //show simpler alternative in this case
    val total2 = numbers.sum()
    println("Total of numbers is: $total2")
}
