package oo.interfaces.conflicts

interface Shop {
    fun open() = println("Shop open")
    fun close() = println("Shop closed")
}

interface Connection {
    fun open() = println("Connection open")
    fun close() = println("Connection closed")
}

class Thing : Shop, Connection {
    override fun open() {
        super<Shop>.open()
    }

    override fun close() {
        super<Connection>.close()
    }
}

fun main() {
    val thing = Thing()
    thing.open()
    thing.close()
}
