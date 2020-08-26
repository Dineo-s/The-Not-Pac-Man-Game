/*
    Class to print out the GameWorld
 */

class Board private constructor(
    private val rows: Int,
    private val columns: Int,
    public val gameBoard: Array<Array<BoardItem>>,
    private var moves: Int,
    private var avatar: Avatar
) {
    // Starting the game world and initializing each space to blank
    companion object {
        fun initializeRandom(rows: Int, columns: Int, walls: Int): Board {
            println("Starting - enter W/A/S/D to move")
            val baseBoard: Array<Array<BoardItem>> = Array(columns + 2) { Array(rows + 2) { Space } }

            val gameBoard = Board(
                rows + 2,
                columns + 2, baseBoard,
                10,
                Avatar(Position(0, 0))
            )

            gameBoard.addWalls()
            gameBoard.addItem(Wall, walls)
            gameBoard.addItem(SilverCoin, 5)
            gameBoard.addItem(GoldCoin, 2)
            gameBoard.addAvatar()

            gameBoard.printWorld()
            return gameBoard
        }
    }


    private fun addAvatar() {
        val x = (1 until rows - 1).random()
        val y = (1 until columns - 1).random()

        if (gameBoard[x][y] is Space) {
            gameBoard[x][y] = avatar
            avatar.location = Position(x, y)
        } else
            addAvatar()
    }

    private fun addItem(boardItem: BoardItem, amount: Int) {
        repeat(amount) {
            val x = (1 until rows - 1).random()
            val y = (1 until columns - 1).random()

            if (gameBoard[x][y] is Space) {
                gameBoard[x][y] = boardItem
            } else
                addItem(boardItem, 1)
        }
    }

    private fun addWalls() {
        gameBoard.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, _ ->

                if (rowIndex == 0 || rowIndex == rows - 1)
                    row[columnIndex] = Wall

                if (columnIndex == 0 || columnIndex == columns - 1)
                    row[columnIndex] = Wall
            }
        }
    }

    public fun printWorld() {
        println("NUMBER OF MOVES LEFT : $moves")

        gameBoard.forEach { r ->
            println(r.joinToString(" ") { c -> c.icon.character })
        }
    }

    fun determainDirection(direction: String) {
        val x = avatar.location.x
        val y = avatar.location.y

        val hasMoved = when (direction) {
            "W" -> moveInDirection(x - 1, y)
            "S" -> moveInDirection(x + 1, y)

            "A" -> moveInDirection(x, y - 1)
            "D" -> moveInDirection(x, y + 1)
            else -> false
        }

        if (hasMoved) {
            gameBoard[x][y] = Space

            if (gameBoard[x][y] is Coin) {
                val coin : Coin = gameBoard[x][y] as Coin
                coin.getPoint()
            }
        }

    }

    fun moveInDirection(x: Int, y: Int): Boolean {
        if (gameBoard[x][y].walkOn) {
            avatar.location = Position(x, y)
            gameBoard[x][y] = avatar

            return true
        }
        return false
    }

/*



    fun iterate2(): GameWorld {


        val copyWorld = createEmptyWorld(rows, columns)

        world.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, cellValue ->

                val neighbourCells: List<Pair<Int, Int>> = listOf(
                    Pair(rowIndex - 1, columnIndex),
                    Pair(rowIndex + 1, columnIndex),
                    Pair(rowIndex, columnIndex - 1),
                    Pair(rowIndex, columnIndex + 1)
                )

                val bugs = neighbourCells.count { (r, c) -> isBug(r, c) }
                // println(bugs)
                //Dies if 1 bug is not next to it
                if (cellValue == Icon.BUG && bugs != 1) {
                    copyWorld[rowIndex][columnIndex] = Icon.BLANK
                }

                //New bug if there are 1 or 2 bugs around
                if (cellValue == Icon.BLANK && bugs == 1 || bugs == 2) {
                    copyWorld[rowIndex][columnIndex] = Icon.BUG
                }

            }

        }

        return GameWorld(rows, columns, copyWorld)
    }

    private fun isBug(r: Int, c: Int): Boolean {
        return r in (0 until rows)
                && c in (0 until columns)
                && world[r][c] == Icon.BUG
    }
*/

}