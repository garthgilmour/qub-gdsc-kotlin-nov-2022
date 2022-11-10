package basics.pairs

fun main() {
    val p1: Pair<Int, String> = 7 to "abc"
    val p2: Pair<Int, String> = 7.to("abc")
    val p3: Pair<String, Int> = "def" to 8
    val p4: Pair<String, Int> = "def".to(8)

    listOf(p1, p2, p3, p4).forEach(::println)
}
