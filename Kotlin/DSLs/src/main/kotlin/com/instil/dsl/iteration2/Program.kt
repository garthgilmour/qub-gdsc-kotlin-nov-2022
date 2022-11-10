package com.instil.dsl.iteration2

class Module(val title: String)

class Course(val title: String) {

    fun module(title: String = "Basic Concepts",
               action: Module.() -> Unit) = Module(title).apply(action)

    override fun toString() = title
}

fun course(title: String = "Coding in Kotlin",
           action: Course.() -> Unit) = Course(title).apply(action)

fun main() {
    val dsl1 = course {
        this.module {
        }
        module("Object Orientation in Kotlin") {
        }
    }
    val dsl2 = course("Programming in Python") {
        module("Introduction to Python") {
        }
        module("The Basics of Python Scripting") {
        }
    }
    println(dsl1)
    println(dsl2)
}