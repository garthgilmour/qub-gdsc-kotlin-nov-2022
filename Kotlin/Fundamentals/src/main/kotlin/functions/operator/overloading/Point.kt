package functions.operator.overloading

class Point(var x: Int, var y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)

    operator fun minus(other: Point) = Point(x - other.x, y - other.y)

    operator fun times(other: Point) = Point(x * other.x, y * other.y)

    operator fun div(other: Point) = Point(x / other.x, y / other.y)

    operator fun get(index: Int) = when(index) {
        0 -> x
        1 -> y
        else -> throw IllegalArgumentException()
    }

    override fun toString() = "Point at $x:$y"
}