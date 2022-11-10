package generics.constraints.multiple

interface Edible {
    fun eat()
}
interface Drinkable {
    fun drink()
}
class Pie : Edible {
    override fun eat() {}
}
class Ale : Drinkable {
    override fun drink() {}
}
class Ramen : Edible, Drinkable {
    override fun eat() {}
    override fun drink() {}
}

fun <T> demo(input: T) where T: Edible, T: Drinkable {
    input.eat()
    input.drink()
}

fun main() {
    //demo(Pie())  // Will not compile
    //demo(Ale())  // Will not compile
    demo(Ramen())
}
