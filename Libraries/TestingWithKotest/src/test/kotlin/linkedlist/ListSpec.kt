package linkedlist

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import list.InvalidIndexException
import list.LinkedList
import list.ListEmptyException

class ListSpec : ShouldSpec() {
    private var list = LinkedList()

    private fun addFiveItems() {
        list.add("abc")
        list.add("def")
        list.add("ghi")
        list.add("jkl")
        list.add("mno")
    }

    init {
        beforeEach {
            list = LinkedList()
        }

        should("be empty initially") {
            list.empty shouldBe true
            list.size shouldBe 0
        }

        should("have size after content is added") {
            addFiveItems()
            list.empty shouldBe false
            list.size shouldBe 5
        }

        should("be able to retrieve the first item") {
            list.add("abc")
            list.get(0) shouldBe "abc"
        }

        should("be able to retrieve multiple items") {
            addFiveItems()
            list.get(0) shouldBe "abc"
            list.get(1) shouldBe "def"
            list.get(2) shouldBe "ghi"
            list.get(3) shouldBe "jkl"
            list.get(4) shouldBe "mno"
        }

        should("throw when accessing an empty list") {
            shouldThrow<ListEmptyException> {
                list.get(0)
            }
        }

        should("throw when accessing with negative index") {
            shouldThrow<InvalidIndexException> {
                addFiveItems()
                list.get(-1)
            }
        }

        should("throw when accessing with invalid index") {
            shouldThrow<InvalidIndexException> {
                addFiveItems()
                list.get(5)
            }
        }
    }
}
