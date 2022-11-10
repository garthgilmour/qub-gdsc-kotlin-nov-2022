package basics.enums

fun main() {
    for (person in CartoonCharacter.values()) {
        println("$person:\t${person.quote}")
    }
    for (direction in Direction.values()) {
        println("---------")
        direction.print()
    }
}
