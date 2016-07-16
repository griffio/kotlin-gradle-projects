package griffio.things

inline fun <reified T> matrix2d(height: Int, width: Int, init: (Int, Int) -> Array<T>) = Array<Array<T>>(height, { row -> init(row, width) })

fun main(args: Array<String>) {

    val table = matrix2d(5, 10, { row: Int, width: Int -> Array(width) { col -> "|$row$col" } })

    for (cells in table) {
        for (cell in cells) {
            print(cell)
        }
        println("|")
    }
}