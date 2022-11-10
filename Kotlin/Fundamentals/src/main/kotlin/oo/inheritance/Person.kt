package oo.inheritance

open class Person(val name: String, val age: Int) {
    constructor(name: String) : this(name, 27)
}

class Employee(name: String, age: Int, val salary: Double) : Person(name, age) {
    override fun toString(): String = "$name of age $age earning $salary"
}

class Customer : Person {
    private var address: String = ""

    constructor(name: String, age: Int, address: String) : super(name, age) {
        this.address = address
    }
    constructor(name: String, address: String) : super(name) {
        this.address = address
    }
    override fun toString(): String = "$name of age $age working at $address"
}

fun main() {
    val emp1 = Employee("John Smith", 27, 30000.0)
    val cust1 = Customer("Jane Smith", 32, "12 Arcatia Road")
    val cust2 = Customer("Mary Wilson", 34, "14 Arcatia Road")

    println(emp1)
    println(cust1)
    println(cust2)
}
