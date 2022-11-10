package cell

import cell.CellStates.Alive
import cell.CellStates.Dead

class GameOfLifeCell(private val neighbours: List<GameOfLifeCell>) {
    private var cellState = Dead

    init {
        if (neighbours.size > 8) {
            throw CellStateException("Too many neighbours")
        }
    }

    val state: CellStates
        get() = cellState

    fun makeAlive() {
        cellState = Alive
    }
    fun makeDead() {
        cellState = Dead
    }
    fun changeState() {
        //Deliberately introduces a bug
        //fun countAliveNeighbours() = (0 until neighbours.size - 1).count {
        fun countAliveNeighbours() = neighbours.indices.count {
            neighbours[it].cellState == Alive
        }

        val count = countAliveNeighbours()
        if (cellState == Dead) {
            if (count == 3) {
                makeAlive()
            }
        } else if (cellState == Alive) {
            if (count > 3 || count < 2) {
                makeDead()
            }
        }
    }
}
