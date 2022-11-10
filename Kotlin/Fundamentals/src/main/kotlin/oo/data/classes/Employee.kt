package oo.data.classes

fun main() {
    val emp1 = Employee("Dave Jones", "10 Arcatia Road", 30000.0)
    val emp2 = Employee("Dave Jones", "10 Arcatia Road", 30000.0)

    println(emp1)

    println(emp2)

    println(emp1 === emp2)

    println(emp1 == emp2)

    println(emp1.equals(emp2))

    println(emp1.hashCode())

    println(emp2.hashCode())

    val emp3 = emp2.copy(salary = 40000.0)
    println(emp3)
}

data class Employee(val name: String,
                    val address: String,
                    val salary: Double)
