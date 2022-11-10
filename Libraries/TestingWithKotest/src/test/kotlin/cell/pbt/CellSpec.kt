package cell.pbt

import cell.CellStates
import cell.GameOfLifeCell
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.set
import io.kotest.property.forAll

fun genNUniqueIndexes(range: IntRange): Arb<Set<Int>> = Arb.set(
    Arb.int(0, 7),
    range,
    100
)

fun cellWithNAliveNeighbours(indexes: Set<Int>): GameOfLifeCell {
    fun buildNeighbours(size: Int = 8) = MutableList(size) {
        GameOfLifeCell(emptyList())
    }

    fun makeNeighboursAlive(indexes: Set<Int>, neighbours: List<GameOfLifeCell>) {
        indexes.forEach { index ->
            neighbours[index].makeAlive()
        }
    }

    val neighbours = buildNeighbours()
    makeNeighboursAlive(indexes, neighbours)
    return GameOfLifeCell(neighbours)
}

fun checkForCellDeath(indexes: Set<Int>): Boolean {
    val cell = cellWithNAliveNeighbours(indexes)

    cell.makeAlive()
    cell.changeState()
    return cell.state == CellStates.Dead
}

class CellSpec : StringSpec({
    "becomes alive with three live neighbours" {
        forAll(genNUniqueIndexes(3..3)) { indexes ->
           val cell = cellWithNAliveNeighbours(indexes)

            cell.changeState()
           cell.state == CellStates.Alive
        }
    }

    "starves with less than two live neighbours" {
        forAll(genNUniqueIndexes(0..1)) { indexes ->
            checkForCellDeath(indexes)
        }
    }

    "is overcrowded with more than three live neighbours" {
        forAll(genNUniqueIndexes(4..8)) { indexes ->
            checkForCellDeath(indexes)
        }
    }

    "stays dead without three live neighbours" {
        forAll(genNUniqueIndexes(4..8)) { indexes ->
            val cell = cellWithNAliveNeighbours(indexes)

            cell.changeState()
            cell.state == CellStates.Dead
        }
    }
})
