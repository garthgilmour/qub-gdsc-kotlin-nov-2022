package basics.safety

fun foo(input: Int) = if (input > 0) "abc" else "def" //return type is String
fun bar(input: Int) = if (input > 0) "abc" else null  //return type is String?

fun main() {
    val str1 = foo(12) //inferred type is String
    val str2 = bar(34) //inferred type is String?

    val str3: String = foo(12)  //declared type is String
    val str4: String? = bar(34) //declared type must be String?

    println(bar(12)?.toUpperCase())  //safe call operator (success)
    println(bar(-12)?.toUpperCase()) //safe call operator (failure)

    println(bar(12) ?: "wibble")  //elvis operator (success)
    println(bar(-12) ?: "wibble") //elvis operator (failure)

    println(bar(12)!!.toUpperCase()) //NPE operator (success)
    try {
        println(bar(-12)!!.toUpperCase()) //NPE operator (failure)
    } catch (ex: Throwable) {
        println("Finally a NPE :-)")
    }
}
