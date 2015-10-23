package griffio.queens
//https://en.wikipedia.org/wiki/Eight_queens_puzzle
fun main(args: Array<String>) {

    val all: Int = 255
    var count: Int = 0

    fun solutions(ld: Int = 0, cols: Int = 0, rd: Int = 0) {

        var poss: Int = all and (ld or cols or rd).inv()

        while (poss > 0) {
            val queens: Int = poss and poss.unaryMinus()
            poss = poss.minus(queens)
            solutions((ld or queens) shl 1, cols or queens, (rd or queens) shr 1)
        }

        if (cols == all) { count ++ }

    }

    solutions()

    println(count)

}

