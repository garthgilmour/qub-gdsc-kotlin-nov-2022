package com.instil.dsl.iteration1

class Course(val title: String) {
    override fun toString() = title
}

fun course(title: String = "Coding in Kotlin",
           action: Course.() -> Unit) = Course(title).apply(action)

fun main() {
    val dsl1 = course {

    }
    val dsl2 = course("Programing in Python") {

    }
    println(dsl1)
    println(dsl2)
}