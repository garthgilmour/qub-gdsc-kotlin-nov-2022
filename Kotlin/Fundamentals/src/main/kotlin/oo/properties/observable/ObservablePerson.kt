package oo.properties.observable

import kotlin.properties.Delegates

class Person(name: String) {
    var name: String by Delegates.observable(name) { _, new, old ->
        println("$old changed his name to $new")
    }
}

fun main() {
    val person = Person("John")

    person.name = "Bob"
}
