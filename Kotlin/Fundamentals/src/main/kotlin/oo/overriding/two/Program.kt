package oo.overriding.two

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
    val staff = arrayListOf(
        Developer("Jane"),
        Manager("Pete"),
        SalesPerson("Lucy"),
        Developer("Fred"),
        Manager("Mary")
    )

    for (emp in staff) {
        emp.promote()
    }
}
