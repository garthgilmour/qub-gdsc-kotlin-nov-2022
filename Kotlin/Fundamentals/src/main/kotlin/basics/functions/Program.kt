package basics.functions

fun demo1(input: Int) {
    println("Demo1 called with $input")
}

fun demo2(input: Int): Unit { //same as above
    println("Demo2 called with $input")
}

fun demo3(input: Int): String = "Demo3 called with $input"

fun demo4(input: Int): String {
    return "Demo3 called with $input"
}

fun demo5(input: Int = 456): String {
    return "Demo3 called with $input"
}

fun demo6(vararg inputs: Int) = inputs.reduce { a, b -> a + b }

fun demo7(port: Int, timeout: Int, retries: Int): String {
    return """
           Trying to connect on port $port
           with $retries retries and a timeout of $timeout
           """.trimIndent()
}

fun main() {
    demo1(123)
    demo2(123)
    println(demo3(123))
    println(demo4(123))
    println(demo5(123))
    println(demo5())
    println("Adding numbers gives: ${demo6(10, 20, 30, 40, 50)}")
    println(demo7(timeout = 60, port = 8080, retries = 10))
}
