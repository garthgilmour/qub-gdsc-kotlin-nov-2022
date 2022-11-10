package basics.exceptions

fun main() {
    commonSyntax()
    tryAsExpression()
    try {
        theNothingType()
    } catch (ex: Exception) {
        ex.printStackTrace(System.out)
    }
}

fun commonSyntax() {
    try {
        foo(-1)
        println("Success!")
    } catch (ex: IllegalStateException) {
        println(ex.message)
    }
    try {
        foo(1)
        println("Success!")
    } catch (ex: IllegalStateException) {
        println(ex.message)
    }
}

fun tryAsExpression() {
    val message1 = try {
        foo(-1)
        "Success!"
    } catch (ex: Exception) {
        ex.message
    }
    println(message1)
    val message2 = try {
        foo(1)
        "Success!"
    } catch (ex: Exception) {
        ex.message
    }
    println(message2)
}

fun theNothingType() {
    val result1 = possibleDeath(1)
    println(result1)
    certainDeath()

    //val result2 = certainDeath()
    // Will not compile
    //println(result2)
}

fun certainDeath(): Nothing = throw IllegalStateException("Boom!")

fun possibleDeath(input: Int) {
    if (input < 0) throw IllegalStateException("Boom!")
}

fun foo(input: Int) {
    bar(input)
}

fun bar(input: Int) {
    zed(input)
}

fun zed(input: Int) {
    if (input < 0) {
        throw IllegalStateException("Having a bad day...")
    }
}
