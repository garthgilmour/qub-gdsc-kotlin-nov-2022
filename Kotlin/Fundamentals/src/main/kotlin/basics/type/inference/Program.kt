package basics.type.inference

class Person(val name: String)

fun main() {
    //variable names deliberately poor
    // to stress how type inference works
    val a = 123
    val b = "ABC"
    val c = "[A-Z]{3}".toRegex()
    val d = 1..10
    val e = Person("Jason")

    val f = arrayOf(a, b, c, d, e)
    f.forEach { println(it.javaClass.name) }
}
