@file:JvmName("MyStuff")
package interop.tokotlin

fun awkward() {
    println("Function 'awkward' called")
}

class AwkwardKotlin {
    var suggestion: String = "eat fish"

    companion object Extras {
        fun makeSuggestion(k: AwkwardKotlin) {
            println("We recommend you " + k.suggestion)
        }
    }

    fun foo(a: String = "Fred", b: String = "Wilma") {
        println("Fun doDemo called with $a and $b")
    }

    @JvmOverloads
    fun bar(a: String = "Homer", b: String = "Marge") {
        println("Fun bar called with $a and $b")
    }
}