package functions.taking.functions

fun main() {
    invokeNTimes(2, ::foo)
    printLine()
    invokeNTimes(3, ::bar)
    printLine()
    invokeNTimes(4) {
        println("first lambda called with $it")
    }
    printLine()
    invokeNTimes(5) {
        println("second lambda called with $it")
    }
}

fun invokeNTimes(times: Int, func: (Int) -> Unit) {
    for (i in 1..times) {
        func(i)
    }
}

fun foo(input: Int) = println("doDemo called with $input")
fun bar(input: Int) = println("bar called with $input")
fun printLine() = println("---------")
