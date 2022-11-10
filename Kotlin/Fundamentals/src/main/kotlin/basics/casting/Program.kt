package basics.casting

import java.time.LocalTime

class Person(val name: String)

fun doDemo(input: Any) {
    val result = when (input) {
        is String -> input.toUpperCase()
        is LocalTime -> input.hour.toString()
        is Person -> input.name
        else -> input.toString()
    }
    println(result)
}

fun main() {
    doDemo("wibble")
    doDemo(LocalTime.NOON)
    doDemo(Person("Dave"))
    doDemo(123)
}
