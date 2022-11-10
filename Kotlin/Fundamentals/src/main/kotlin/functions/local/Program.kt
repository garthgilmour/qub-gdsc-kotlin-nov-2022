package functions.local

fun main() {
    fibonacci(10000)
}

fun fibonacci(endPoint: Int) {
    fun startList() = println("<ul>")
    fun endList() = println("</ul>")
    fun addItem(item: Int) = println("\t<li>$item</li>")

    var firstNum = 0
    var secondNum = 1

    startList()
    addItem(firstNum)
    addItem(secondNum)
    while (secondNum < endPoint) {
        val result = firstNum + secondNum
        addItem(result)
        firstNum = secondNum
        secondNum = result
    }
    endList()
}
