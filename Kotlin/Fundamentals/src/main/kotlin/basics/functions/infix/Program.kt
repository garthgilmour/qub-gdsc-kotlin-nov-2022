package basics.functions.infix

class Number(val value: Int) {
    infix fun plus(input: Int) = Number(value + input)

    infix fun minus(input: Int) = Number(value - input)

    fun doTimes(action: (Int) -> Unit) {
        for (x in 1..value) {
            action(x)
        }
    }
}

fun main() {
    val num1 = Number(5)
    val num2 = num1 plus 7
    val num3 = num2 minus 3
    num1.doTimes { print("$it ") }
    println()
    num2.doTimes { print("$it ") }
    println()
    num3.doTimes { print("$it ") }
}
