package griffio.things

inline fun <reified T> matrix(height:Int, width:Int, noinline init: (Int, Int) -> Array<T>) = Array<Array<T>>(height, {row-> init(row, width)})

fun main(args: Array<String>) {
    val stringTable = matrix(5, 10, { row:Int, width:Int -> Array(width) {col-> "|$row$col"} })

    for (rows in stringTable) {
        for (row in rows) {
            for (cell in row) {
                print(cell)
            }
        }
        println("|\n")
    }
}