package oo.properties.regular

fun main() {
    val p = Person()
    println(p.name)
    p.sayHello()
    p.name = "Jane"
    println(p.name)
    p.sayHello()
}

class Person {
    var name: String = "Dave"

    fun sayHello() = println("Hello $name")
}
