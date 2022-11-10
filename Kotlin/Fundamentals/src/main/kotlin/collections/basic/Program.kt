package collections.basic

fun printList(input: List<Int>) {
    println("This is a list of type ${input.javaClass.name}")
    if (input.isEmpty()) {
        println("\tThe list is empty")
    } else {
        val content = input.fold("") { a, b -> a + b + " " }
        println("\tThe list holds: $content")
    }
}

fun main() {
    val list1: List<Int> = emptyList()
    val list2 = emptyList<Int>()
    val list3 = listOf(12)
    val list4 = listOf(12, 34, 56)
    val list5 = mutableListOf(12, 34, 56)

    printList(list1)
    printList(list2)
    printList(list3)
    printList(list4)
    printList(list5)

    val list6 = list4.plus(78)
    list5.add(78)

    println("-------------")
    printList(list4)
    printList(list5)
    printList(list6)
}
