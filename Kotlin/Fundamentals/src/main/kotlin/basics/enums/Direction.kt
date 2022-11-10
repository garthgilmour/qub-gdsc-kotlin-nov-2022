package basics.enums

enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    fun print() = when (this) {
        NORTH -> {
            println("/\\")
            println("/\\")
            println("/\\")
        }
        SOUTH -> {
            println("\\/")
            println("\\/")
            println("\\/")
        }
        EAST -> println(">>>")
        WEST -> println("<<<")
    }
}