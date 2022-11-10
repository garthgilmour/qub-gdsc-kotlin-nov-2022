package basics.with

class Turtle {
    fun turnRight(degrees: Int = 90) = println("Turtle turning $degrees right")
    fun turnLeft(degrees: Int = 90) = println("Turtle turning $degrees left")
    fun forward(distance: Int = 10) = println("Turtle moving $distance forward")
    fun back(distance: Int = 10) = println("Turtle moving $distance back")
    fun penUp() = println("Turtle pen up")
    fun penDown() = println("Turtle pen down")
}

fun main() {
    val turtle = Turtle()
    with(turtle) {
        forward(100)
        turnRight()
        penDown()
        forward(50)
        penUp()
    }
}
