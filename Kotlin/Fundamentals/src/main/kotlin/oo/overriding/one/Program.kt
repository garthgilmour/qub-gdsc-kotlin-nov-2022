package oo.overriding.one

open class Employee(val name: String) {
    open fun promote() = println("Employee $name has been promoted")
}

class Developer(name: String) : Employee(name) {
    override fun promote() = println("Developer $name has been promoted")
}

class Manager(name: String) : Employee(name) {
    override fun promote() = println("Manager $name has been promoted")
}

class SalesPerson(name: String) : Employee(name) {
    override fun promote() = println("Sales person $name has been promoted")
}

fun main() {
    fun demo(input: Employee) {
        input.promote()
    }
    val emp1 = Developer("Jane")
    val emp2 = Manager("Mary")
    val emp3 = SalesPerson("Lucy")

    demo(emp1)
    demo(emp2)
    demo(emp3)
}
