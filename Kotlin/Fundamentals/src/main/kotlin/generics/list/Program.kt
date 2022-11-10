package generics.list

class Person(val name: String, private val age: Int) {
    override fun toString(): String {
        return "$name of age $age"
    }
}

fun main() {
    val stringList = LinkedList<String>()
    val personList = LinkedList<Person>()

    stringList.add("abc")
    stringList.add("def")
    stringList.add("ghi")
    stringList.add("jkl")

    personList.add(Person("dave", 20))
    personList.add(Person("jane", 21))
    personList.add(Person("pete", 22))
    personList.add(Person("mary", 23))

    println("Here are the strings")
    for (x in 0 until stringList.size) {
        println(stringList.get(x))
    }

    println("Here are the people")
    for (x in 0 until personList.size) {
        println(personList.get(x))
    }
}
