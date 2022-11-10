package basics.repeat

fun sample(x: Int) = println("Hello $x")

fun main() {
    repeat(4, ::sample)
    repeat(5) { x -> println("Bye $x") }
}
