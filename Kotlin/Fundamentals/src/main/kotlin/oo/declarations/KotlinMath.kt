package oo.declarations

object KotlinMath {
    fun add(no1: Int, no2: Int) = no1 + no2
    fun subtract(no1: Int, no2: Int) = no1 - no2
}

data class Employee(val name: String, val dept: String) {
    companion object ExtraStuff {
        fun buildForHR(name: String) = Employee(name, "HR")
        fun buildForIT(name: String) = Employee(name, "IT")
    }
}

fun main() {
    println(KotlinMath.add(12, 34))
    println(KotlinMath.subtract(56, 78))

    val emp1 = Employee("Jane", "Sales")
    val emp2 = Employee.buildForHR("Mary")
    val emp3 = Employee.buildForIT("Lucy")

    println(emp1)
    println(emp2)
    println(emp3)
}
