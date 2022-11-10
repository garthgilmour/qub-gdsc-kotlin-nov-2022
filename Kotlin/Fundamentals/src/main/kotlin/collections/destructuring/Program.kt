package collections.destructuring

fun main() {
    val myList = listOf(12, 34, 56)
    val myPair = Pair(12, "ab")
    val (a, b, c) = myList
    val (d, e) = myPair

    println("List values are $a, $b and $c")
    println("Pair values are $d and $e")
}
