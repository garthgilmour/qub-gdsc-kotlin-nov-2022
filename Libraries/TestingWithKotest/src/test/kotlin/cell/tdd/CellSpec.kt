package cell.tdd

import cell.CellStateException
import cell.CellStates.Alive
import cell.CellStates.Dead
import cell.GameOfLifeCell
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class CellSpec : ShouldSpec() {
    private var neighbours = buildNeighbours()
    private var cell: GameOfLifeCell = GameOfLifeCell(neighbours)

    private fun buildNeighbours(size: Int = 8) = MutableList(size) {
        GameOfLifeCell(emptyList())
    }

    private fun makeNofNeighboursAlive(count: Int) = (0 until count).forEach {
        neighbours[it].makeAlive()
    }

    init {
        beforeEach {
            neighbours = buildNeighbours(8)
            cell = GameOfLifeCell(neighbours)
        }

        should("throw when it has too many neighbours") {
            shouldThrow<CellStateException> {
                GameOfLifeCell(buildNeighbours(9))
            }
        }

        should("be dead by default") {
            cell.state shouldBe Dead
        }

        should("live on command") {
            cell.makeAlive()
            cell.state shouldBe Alive
        }

        should("die on command") {
            cell.makeAlive()
            cell.makeDead()
            cell.state shouldBe Dead
        }

        should("become alive when three neighbours are alive") {
            makeNofNeighboursAlive(3)
            cell.changeState()
            cell.state shouldBe Alive
        }

        should("starve when less than two neighbours are alive") {
            cell.makeAlive()
            neighbours[0].makeAlive()
            cell.changeState()
            cell.state shouldBe Dead
        }

        should("be overcrowded when more than three neighbours are alive") {
            cell.makeAlive()
            (0..3).forEach {
                neighbours[it].makeAlive()
            }
            cell.changeState()
            cell.state shouldBe Dead
        }

        (0..8).forEach { count ->
            makeNofNeighboursAlive(count)
            should("stay dead unless three neighbours are alive") {
                cell.changeState()
                if (count != 3) {
                    cell.state shouldBe Dead
                }
            }
        }
    }
}
