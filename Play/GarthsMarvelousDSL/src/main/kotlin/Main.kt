
interface Node {
    fun marshall(): String
}

abstract class ContainerNode<T: Node>(private val tagName: String): Node {
    private val children = mutableListOf<T>()

    private fun marshallChildren(): String {
        return children.joinToString(separator="\n") { it.marshall() }
    }

    override fun marshall() = """
        |<$tagName>
        |${marshallChildren()}
        |</$tagName>
    """.trimMargin("|")

    protected fun addAndConfigureChild(
        child: T,
        action: T.() -> Unit
    ) = child.apply(action).also { children.add(it) }

    protected fun addChild(child: T) = children.add(child)
}

class Course(private val title: String): ContainerNode<Module>("html") {

    override fun toString() = "Some damn DSL with title $title"

    fun module(title: String = "Default title", action: Module.() -> Unit): Module {
        return addAndConfigureChild(Module(title), action)
    }
}
class Module(val title: String): ContainerNode<Section>("section") {

    fun section(index: Int = 0, action: Section.() -> Unit): Section {
        return addAndConfigureChild(Section(index), action)
    }
}
class Section(val index: Int): ContainerNode<Topic>("article") {
    operator fun String.unaryPlus() {
        addChild(Topic(this))
    }
}

class Topic(private val content: String): Node {
    override fun marshall() = "<p>$content</p>"
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
    println(dsl1.marshall())
    println(dsl2.marshall())
}
