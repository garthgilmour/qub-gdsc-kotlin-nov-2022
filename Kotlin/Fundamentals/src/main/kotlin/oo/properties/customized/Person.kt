package oo.properties.customized

fun main() {
    val p = Person()
    println(p.name)
    p.sayHello()
    p.name = "Jane"
    p.sayHello()
    println(p.name)
}

class Person {
    var name: String = "Dave"
        get() = "[$field]"
        set(value) { field = "$value Jones" }

    fun sayHello() = println("Hello $name")
}
