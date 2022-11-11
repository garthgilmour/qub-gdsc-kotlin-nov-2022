class Course(val title: String) {
    override fun toString() = "Some damn DSL with title $title"

    fun module(title: String = "Default title", action: Module.() -> Unit): Module {
        return Module(title).apply(action)
    }
}
class Module(val title: String) {
    fun section(index: Int = 0, action: Section.() -> Unit): Section {
        return Section(index).apply(action)
    }
}
class Section(val index: Int) {
    operator fun String.unaryPlus() {}
}

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
        }
    }
    println(dsl1)
    println(dsl2)
}
