package oo.extensions

data class Employee(val name: String, var yearlySalary: Double) {
    fun awardBonus(bonus: Double) {
        yearlySalary += bonus
    }
}

fun Employee.calcSalary() = this.yearlySalary / 12

fun String.square() = this + this

fun main() {
    val str1 = "abc"
    val str2 = str1.square()

    val emp = Employee("Peter", 60000.0)
    emp.awardBonus(240.0)

    println(str1)
    println(str2)
    println(emp)
    println(emp.calcSalary())
}
