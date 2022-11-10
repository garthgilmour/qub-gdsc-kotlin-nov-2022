package generics.declaration.site.variance

open class Employee
open class Manager : Employee()
open class Director : Manager()

class ReadWriteList<T> {
    fun get(index: Int): T? = null
    fun findFirst(p: (T) -> Boolean): T? = null
    fun findAll(p: (T) -> Boolean): ReadWriteList<T>? = null
    fun add(item: T) {}
    fun add(index: Int, item: T) {}
    fun addAll(items: ReadWriteList<T>) {}
}
class ReadOnlyList<out T> {
    fun get(index: Int): T? = null
    fun findFirst(p: (T) -> Boolean): T? = null
    fun findAll(p: (T) -> Boolean): ReadOnlyList<T>? = null
}
class WriteOnlyList<in T> {
    fun add(item: T) {}
    fun add(index: Int, item: T) {}
    fun addAll(vararg items: T) {}
}

fun demo1(input: ReadWriteList<Manager>) {
    //input.add(Employee())
    input.add(Manager())  //this is not controversial
    input.add(Director()) //this surprises most people
}
fun demo2(input: ReadOnlyList<Manager>) {
    //can only access items here
}
fun demo3(input: WriteOnlyList<Manager>) {
    //can only insert items here
}

fun main() {
    //demo1(ReadWriteList<Employee>()) //will not compile
    demo1(ReadWriteList<Manager>())
    //demo1(ReadWriteList<Director>()) //will not compile

    //demo2(ReadOnlyList<Employee>()) //will not compile
    demo2(ReadOnlyList<Manager>())
    demo2(ReadOnlyList<Director>())

    demo3(WriteOnlyList<Employee>())
    demo3(WriteOnlyList<Manager>())
    //demo3(WriteOnlyList<Director>()) //will not compile
}
