package basics.selection

fun main() {
    println("Enter a number")
    val num = Integer.parseInt(readLine())

    val message1 = if (num % 2 == 0) "even" else "odd"
    println("The number is $message1")

    val message2: String
    if (num % 2 == 0) {
        message2 = "even"
    } else {
        message2 = "odd"
    }
    println("The number is $message2")

    val tmpList = listOf<Int>(60, 70, 80)

    val message3 = when (num) {
        10 -> "The number is 10"
        20, 30, 40 -> "The number is 20, 30 or 40"
        in 41..50 -> "The number is between 41 and 50"
        in tmpList -> "The number is 60,70 or 80"
        else -> "This number perplexes me..."
    }
    println(message3)

    val message4: String
    when (num) {
        10 -> message4 = "The number is 10"
        20, 30, 40 -> message4 = "The number is 20, 30 or 40"
        in 41..50 -> message4 = "The number is between 41 and 50"
        in tmpList -> message4 = "The number is 60,70 or 80"
        else -> message4 = "This number perplexes me..."
    }
    println(message4)
}
