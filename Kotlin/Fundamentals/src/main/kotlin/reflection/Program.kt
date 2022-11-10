package reflection

import kotlin.reflect.KClass
import kotlin.reflect.full.allSuperclasses

open class Person(val name: String, val age: Int) {
    constructor(name: String) : this(name, 27)
}

class Employee(name: String, age: Int, val salary: Double) : Person(name, age) {
    override fun toString(): String = "$name of age $age earning $salary"
}

fun main() {
    val emp = Employee("Dave", 32, 45000.0);
    showJavaReflection(emp.javaClass)
    showKotlinReflection(emp::class)
}

fun showJavaReflection(javaClass: Class<*>) {
    println("\n--- Java Reflection ---")
    println("Name is '${javaClass.simpleName}'")
    println("Base type is '${javaClass.superclass.simpleName}'")
    println("Methods are:")
    javaClass.declaredMethods
        .map { it.name }
        .forEach(::printTabbed)
    println("Fields are:")
    javaClass.declaredFields
        .map { it.name }
        .forEach(::printTabbed)
}

fun showKotlinReflection(kotlinClass: KClass<*>) {
    fun isDataClass() = if(kotlinClass.isData) "is" else "is not"
    fun baseName() = kotlinClass.allSuperclasses.first().simpleName

    println("\n--- Kotlin Reflection ---")
    println("Name is '${kotlinClass.simpleName}'")
    println("Base type is '${baseName()}'")
    println("This ${isDataClass()} a data class")
    println("Properties are:")
    kotlinClass.members
        .map { it.name }
        .forEach(::printTabbed)
}

fun printTabbed(input: Any) = println("\t$input")
