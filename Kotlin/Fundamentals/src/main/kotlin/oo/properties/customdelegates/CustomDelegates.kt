package oo.properties.customdelegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LoggingDelegate<T>(var value: T) : ReadWriteProperty<Any?, T> {
    operator fun provideDelegate(thisRef: Any?, prop: KProperty<*>): ReadWriteProperty<Any?, T> {
        // Unlike a constructor, we have access to the property and bound object
        println("Creating logger for property '${prop.name}'")
        println("Initial value is '$value'")
        return this;
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("Someone is writing to '${property.name}'")
        this.value = value
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("Someone is accessing ${property.name}")
        return value
    }
}

fun <T> logger(initialValue: T): LoggingDelegate<T> {
    return LoggingDelegate(initialValue);
}

class Person(val name: String, job: String) {
    var job: String by logger(job)
    var salary: Double by logger(0.0)
}

fun main() {
    val person = Person("Dave", "Developer")

    person.job = "Senior Developer"
    println(person.job)
}
