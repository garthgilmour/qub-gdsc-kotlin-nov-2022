package com.instil.dsl.iteration4

interface Node {
    fun render(builder: StringBuilder) : StringBuilder
}

class Topic(val text: String) : Node {
    override fun render(builder: StringBuilder): StringBuilder {
        builder.append("\t\tTopic called '$text'\n")
        return builder
    }
}

class Module(val title: String) : Node {
    private val children = mutableListOf<Topic>()

    override fun render(builder: StringBuilder): StringBuilder {
        builder.append("\tModule called '$title'\n")
        return children.fold(builder) { state, child ->
            child.render(state)
        }
    }

    operator fun String.unaryPlus() = children.add(Topic(this))
}

class Course(val title: String) : Node {
    private val children = mutableListOf<Module>()

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
            +"Declarations and type inference"
            +"The Kotlin type system and conversions"
            +"Packages, access levels and default imports"
            +"Nullable types and operators for null safety"
            +"Keywords for selection and iteration"
            +"Options for declaring basic functions"
            +"Overloading, infix functions and ranges"
        }
        module("Object Orientation in Kotlin") {
            +"Decompiling Kotlin classes using ‘javap’"
            +"Understanding properties and backing fields"
            +"A detailed explanation of primary constructors"
            +"Adding extra fields and secondary constructors"
            +"Extra features automatically added to data classes"
            +"Overriding, abstract classes and interfaces"
            +"Using object expressions as event handlers"
            +"Object declarations and companion objects"
        }
    }
    val dsl2 = course("Programming in Python") {
        module("Introduction to Python") {
            +"The evolution of Python from Shell Scripting and Perl"
            +"Installing Python and running / debugging simple scripts"
            +"Differences between Python 3 and earlier versions"
            +"Using the JVM and CLR based Python interpreters"
            +"Comparing Python to Ruby, JavaScript and PowerShell"
        }
        module("The Basics of Python Scripting") {
            +"Declaring and modifying variables"
            +"Reading and writing from the console"
            +"Working with the built in data types"
            +"Making choices and performing iteration"
            +"Declaring functions and passing parameters"
            +"Identity, equality and references"
        }
    }
    println(dsl1)
    println(dsl2)
}