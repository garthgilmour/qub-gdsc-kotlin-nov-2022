package generics.list

class LinkedList<T> {
    private var first: Node<T>? = null

    var empty = true
        get() = size == 0
    var size = 0
        private set

    fun add(item: T) {
        fun walkToLastNode(): Node<T>? {
            var current = first
            while (current?.next != null) {
                current = current.next
            }
            return current
        }

        if (empty) {
            first = Node<T>(null, null, item)
        } else {
            val last = walkToLastNode()
            last?.next = Node<T>(null, last, item)
        }
        size++
    }

    fun get(index: Int): T? {
        fun walkToSelectedNode(): Node<T>? {
            var current = first
            for (x in 1..index) {
                current = current?.next
            }
            return current
        }

        if (empty) {
            throw ListEmptyException("Cant index into empty list")
        }

        if (index < 0 || index >= size) {
            throw InvalidIndexException("Cannot use $index as an index")
        }
        return walkToSelectedNode()?.payload
    }
}
