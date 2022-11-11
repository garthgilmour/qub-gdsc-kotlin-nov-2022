
abstract class Container<T> {
    protected val children = mutableListOf<T>()
}

class Course(val title: String): Container<Module>() {

    override fun toString() = "Some damn DSL with title $title"

    fun module(title: String = "Default title", action: Module.() -> Unit): Module {
        return Module(title).apply(action).also { children.add(it) }
    }
}
class Module(val title: String): Container<Section>() {

    fun section(index: Int = 0, action: Section.() -> Unit): Section {
        return Section(index).apply(action).also { children.add(it) }
    }
}
class Section(val index: Int): Container<Topic>() {
    operator fun String.unaryPlus() {
        children.add(Topic(this))
    }
}

class Topic(val content: String)

fun course(title: String = "Default title", action: Course.() -> Unit): Course {
    return Course(title).apply(action)
}
fun main(args: Array<String>) {
    println("My DSL For Training Courses")

    val dsl1 = course {
        module {
            section {
                +"topic A"
                +"topic B"
                +"topic C"
            }
            section {
                +"topic A"
                +"topic B"
                +"topic C"
            }
            section {
                +"topic A"
                +"topic B"
                +"topic C"
            }
        }
    }

    val dsl2 = course("Kotlin 101") {
        module("OO In Kotlin") {
            section(0) {
                +"Classes"
                +"Objects"
                +"Methods"
                +"Fields"
            }
            section(1) {
                +"Encapsulation"
                +"Abstraction"
                +"Polymorphism"
            }
        }
    }
    println(dsl1)
    println(dsl2)
}
