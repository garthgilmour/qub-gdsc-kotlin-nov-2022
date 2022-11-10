package list

class LinkedList {
    private var first: Node? = null

    val empty
        get() = size == 0
    var size = 0
        private set

    fun add(item: String) {
        fun walkToLastNode(): Node? {
            var current = first
            while (current?.next != null) {
                current = current.next
            }
            return current
        }
        if (empty) {
            first = Node(null, null, item)
        } else {
            val last = walkToLastNode()
            last?.next = Node(null, last, item)
        }
        size++
    }

    fun get(index: Int): String? {
        fun walkToSelectedNode(): Node? {
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
