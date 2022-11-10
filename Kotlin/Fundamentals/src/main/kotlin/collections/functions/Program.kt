package collections.functions

fun main() {
    val myList = listOf("ab", "cd", "ef")

    println(myList.elementAtOrElse(0) { "Nothing at $it" })
    println(myList.elementAtOrElse(3) { "Nothing at $it" })

    val sb = StringBuilder()
    myList.joinTo(buffer = sb, separator = " ", prefix = ">>", postfix = "<<")
    println(sb)

    val myList2 = myList.reversed()
    println(myList2)
}
