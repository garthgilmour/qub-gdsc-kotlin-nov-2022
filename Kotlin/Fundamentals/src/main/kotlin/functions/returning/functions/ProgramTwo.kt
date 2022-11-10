package functions.returning.functions

import kotlin.text.Regex

fun main() {
    val data = "abcDEFghiJKLmnpPQRstuVWXyz"
    val matcher1 = buildMatcher("[A-Z]{3}")
    val matcher2 = buildMatcher("[a-z]{2,3}")

    println("First matches are:")
    for (str in matcher1(data)) {
        println("\t$str")
    }
    println("Second matches are:")
    for (str in matcher2(data)) {
        println("\t$str")
    }
}

fun buildMatcher(pattern: String): (String) -> Sequence<String> {
    fun matcher(text: String): Sequence<String> {
        val regex = Regex(pattern)
        return regex.findAll(text)
                    .map { it.value }
    }
    return ::matcher
}
