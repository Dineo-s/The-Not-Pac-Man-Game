fun main() {
    val board = Board.initializeRandom(5,5,4)
    while (true) {

        board.determainDirection(validateMove() ?: continue)

    //    board = board.iterate2()
        board.printWorld()
    }

}

fun validateMove() : String?{
    val direction = readLine()?.toUpperCase()

    return when (direction){
        "W" -> direction
        "A" -> direction
        "S" -> direction
        "D" -> direction
        else ->{
            println("Invalid move try again:")
            null
        }
    }
}
