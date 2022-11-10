package interop.tojava

fun main() {
    val obj = AwkwardJava()

    val defaultIdea = obj.suggestion
    try {
        defaultIdea.toUpperCase()
    } catch (ex: Exception) {
        println("Whoops...")
    }

    obj.suggestion = "go surfing"
    obj.`object`()

    obj.isAwkward = true
    obj.`object`()
}
