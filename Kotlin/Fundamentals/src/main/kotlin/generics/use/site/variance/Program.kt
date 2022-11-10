package generics.use.site.variance

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

fun copyFirstTen(input: ReadWriteList<out Employee>, output: ReadWriteList<in Employee>) {
    //try to copy first 10 items
    for (x in 0..9) {
        val item = input.get(x)
        if (item != null) {
            output.add(item)
        }
    }
}

fun main() {
    val tst1 = ReadWriteList<Employee>()
    val tst2 = ReadWriteList<Manager>()
    val tst3 = ReadWriteList<Director>()

    copyFirstTen(tst1, tst1)     //fine
    copyFirstTen(tst2, tst1)     //fine
    copyFirstTen(tst3, tst1)     //fine
    //copyFirstTen(tst1, tst2)   //will not compile
    //copyFirstTen(tst1, tst3)   //will not compile
}
