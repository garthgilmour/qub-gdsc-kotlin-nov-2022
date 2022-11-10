package oo.properties.lazy

class Person(val name: String, val job: String) {
    val title: String by lazy {
        println("-- Working out title for $name --")
        "$job $name"
    }
}

fun main() {
    val person1 = Person("Dave", "Developer")
    val person2 = Person("Jane", "Architect")

    println(person1.title)
    println(person1.title)
    println(person1.title)

    println(person2.title)
    println(person2.title)
    println(person1.title)
}
