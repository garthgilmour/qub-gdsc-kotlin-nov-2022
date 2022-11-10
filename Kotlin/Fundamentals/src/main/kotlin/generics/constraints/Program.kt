package generics.constraints

open class Employee {
    fun work() {}
}
open class Manager : Employee() {
    fun manage() {}
}
open class Director : Manager() {
    fun direct() {}
}

fun <T> demo1(input: T) {
    println(input.toString())
}
fun <T : Employee> demo2(input: T) {
    input.work()
}
fun <T : Manager> demo3(input: T) {
    input.work()
    input.manage()
}
fun <T : Director> demo4(input: T) {
    input.work()
    input.manage()
    input.direct()
}

fun main() {
    demo1(Employee())
    demo1(Manager())
    demo1(Director())

    demo2(Employee())
    demo2(Manager())
    demo2(Director())

    //demo3(Employee()) // Will not compile
    demo3(Manager())
    demo3(Director())

    //demo4(Employee()) // Will not compile
    //demo4(Manager())  // Will not compile
    demo4(Director())
}
