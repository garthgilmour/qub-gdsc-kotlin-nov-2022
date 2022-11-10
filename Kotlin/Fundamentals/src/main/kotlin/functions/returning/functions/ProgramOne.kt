package functions.returning.functions

fun main() {
    println(wrapInH1("Marge"))
    println(wrapInH2("Homer"))
    println(wrapInTag("h3", "Liza"))
    println(wrapInTag("h4", "Bart"))

    val wrapInBold = buildWrapper("b")
    val wrapInItalics = buildWrapper("i")
    val wrapInMark = buildWrapper("mark")

    println(wrapInBold("Maggie"))
    println(wrapInItalics("Snowball III"))
    println(wrapInMark("Santas Little Helper"))
}
fun wrapInH1(input: String) = "<h1>$input</h1>"
fun wrapInH2(input: String) = "<h2>$input</h2>"

fun wrapInTag(tagName: String, input: String): String {
    return "<$tagName>$input</$tagName>"
}

fun buildWrapper(tagName: String): (String) -> String {
    return { "<$tagName>$it</$tagName>" }
}
