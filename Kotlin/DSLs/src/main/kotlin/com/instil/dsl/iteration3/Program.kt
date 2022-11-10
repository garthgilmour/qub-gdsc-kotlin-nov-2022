package com.instil.dsl.iteration3

interface Node {
    fun render(builder: StringBuilder) : StringBuilder
}

class Module(val title: String) : Node {
    override fun render(builder: StringBuilder): StringBuilder {
        builder.append("\tModule called '$title'\n")
        return builder
    }
}

class Course(val title: String) : Node {
    private val children = mutableListOf<Node>()

    fun module(title: String = "Basic Concepts",
               action: Module.() -> Unit)
            = Module(title).apply(action).also { children.add(it) }

    override fun render(builder: StringBuilder): StringBuilder {
        builder.append("Course entitled: '$title'\n")
        return children.fold(builder) { state, child ->
            child.render(state)
        }
    }

    override fun toString() = render(StringBuilder()).toString()
}

fun course(title: String = "Coding in Kotlin",
           action: Course.() -> Unit) = Course(title).apply(action)

fun main() {
    val dsl1 = course {
        module("First Steps with Kotlin") {
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