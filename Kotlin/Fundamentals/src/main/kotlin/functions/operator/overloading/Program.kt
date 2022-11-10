package functions.operator.overloading

fun main() {
    val p1 = Point(12,14)
    val p2 = Point(23,25)
    val p3 = p1 + p2
    val p4 = p1 - p2
    val p5 = p1 * p2
    val p6 = p1 / p2

    println(p1)
    println(p2)
    println(p3)
    println(p4)
    println(p5)
    println(p6)

    val result1 = p1[0]
    val result2 = p1[1]
    println("Indexing gives $result1 and $result2")
}
