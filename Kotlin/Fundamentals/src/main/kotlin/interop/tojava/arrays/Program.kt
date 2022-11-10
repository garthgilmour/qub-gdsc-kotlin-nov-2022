package interop.tojava.arrays

fun main() {
    val testInput = arrayOf(Employee(), Employee())

    val javaUser = JavaArrayUser()
    javaUser.useArray(testInput)

    //val kotlinUser = KotlinArrayUser()
    // This will not compile
    //kotlinUser.useArray(testInput)
}
