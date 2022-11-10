package collections.sequences

fun main() {
    demoIterable()
    demoSequence()
}

fun demoIterable() {
    println("Working with iterables")
    val input = listOf("abc", "de", "fgh", "ij", "klm")
    println("\tCreated list")
    val results = input.filter {
        println("\t\tFiltering $it")
        it.length == 3
    }.map {
        println("\t\tMapping $it")
        it.toUpperCase()
    }
    println("\tOperations called")
    println("\tResults are:")
    results.forEach { println("\t\t$it") }
}

fun demoSequence() {
    println("Working with sequences")
    val input = listOf("abc", "de", "fgh", "ij", "klm").asSequence()
    println("\tCreated sequence")
    val results = input.filter {
        println("\t\tFiltering $it")
        it.length == 3
    }.map {
        println("\t\tMapping $it")
        it.toUpperCase()
    }
    println("\tOperations called")
    println("\tResults are:")
    results.forEach { println("\t\t$it") }
}

