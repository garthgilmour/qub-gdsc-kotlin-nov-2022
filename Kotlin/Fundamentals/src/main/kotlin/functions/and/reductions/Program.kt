package functions.and.reductions

fun main() {
    val data = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    sumViaReduce(data)
    productViaReduce(data)
    countViaReduce(data)
    averageViaReduce(data)
    lastViaReduce(data)
    penultimateViaReduce(data)
    reverseViaReduce(data)
}

fun sumViaReduce(data: Iterable<Int>) {
    val result = data.reduce(Int::plus)
    println("Sum of elements is $result")
}

fun productViaReduce(data: Iterable<Int>) {
    val result = data.reduce(Int::times)
    println("Product of elements is $result")
}

fun countViaReduce(data: Iterable<Int>) {
    val result = data.fold(0, { sum, _ -> sum + 1 })
    println("Count of elements is $result")
}

fun averageViaReduce(data: Iterable<Int>) {
    fun operator(oldPair: Pair<Double, Double>, item: Int): Pair<Double, Double> {
        return Pair(oldPair.first + item, oldPair.second + 1)
    }
    val output = data.fold(Pair(0.0, 0.0), ::operator)
    val average = output.first / output.second
    println("Average of elements is $average")
}

fun lastViaReduce(data: Iterable<Int>) {
    val result = data.reduce { _, b -> b }
    println("The last element is $result")
}

fun penultimateViaReduce(data: Iterable<Int>) {
    val lastTwoItems = data.fold(Pair(0, 0)) { a, b -> Pair(a.second, b) }
    val penultimateItem = lastTwoItems.first
    println("The penultimate element is $penultimateItem")
}

fun reverseViaReduce(data: Iterable<Int>) {
    val results = data.fold(emptyList<Int>()) { items, item -> listOf(item) + items }
    println("The list in reverse is:")
    for (value in results) {
        print("\t$value ")
    }
}
