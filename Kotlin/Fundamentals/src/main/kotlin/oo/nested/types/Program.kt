package oo.nested.types

class Foo(val name: String, otherName: String) {
    val bar = Bar(otherName)

    inner class Bar(val name: String) {
        fun String.zed(name: String): String {
            val test: String.() -> String = {
                val a = this@Foo.name
                val b = this@Bar.name
                val c = this@zed
                val d = this

                listOf(a, b, c, d).joinToString()
            }
            return name.test()
        }
    }
}

fun main() {
    val fooInstance = Foo("Fred", "Wilma")
    val barInstance = fooInstance.bar
    val result = barInstance.run {
        "Barney".zed("Betty")
    }

    println(result)
}
