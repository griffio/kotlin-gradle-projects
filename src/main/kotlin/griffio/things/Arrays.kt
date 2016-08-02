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

    helical2d()

}

enum class HelicalDirection {
    RIGHT,
    LEFT,
    UP,
    DOWN
}

fun helical2d() {

    val rc: Array<CharArray>
    rc = arrayOf(
            charArrayOf('A', 'B', 'C', 'D'),
            charArrayOf('L', 'M', 'N', 'E'),
            charArrayOf('K', 'P', 'O', 'F'),
            charArrayOf('J', 'I', 'H', 'G'))

    val lr = object {
        var left: Int = 0
        var right: Int = 0
    }

    val tb = object {
        var top: Int = 0
        var bottom: Int = 0
    }

    lr.right = rc.size - 1
    tb.bottom = rc[0].size - 1

    var direction = HelicalDirection.RIGHT

    while (lr.left <= lr.right && tb.top <= tb.bottom) {

        when (direction) {
            HelicalDirection.RIGHT -> {
                for (i in lr.left..lr.right) {
                    println(rc[tb.top][i])
                }
                tb.top++
                direction = HelicalDirection.DOWN
            }
            HelicalDirection.DOWN -> {
                for (i in tb.top..tb.bottom) {
                    println(rc[i][lr.right])
                }
                lr.right--
                direction = HelicalDirection.LEFT
            }
            HelicalDirection.LEFT -> {
                for (i in lr.right downTo lr.left) {
                    println(rc[tb.bottom][i])
                }
                tb.bottom--
                direction = HelicalDirection.UP
            }
            HelicalDirection.UP -> {
                for (i in tb.bottom downTo tb.top) {
                    println(rc[i][lr.left])
                }
                lr.left++
                direction = HelicalDirection.RIGHT
            }
        }
    }
}
