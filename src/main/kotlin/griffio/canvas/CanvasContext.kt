package griffio.canvas

class CanvasContext(val height: Int, val width: Int) {

    init {
        require(height > 0 && width > 0, { "a non zero height and width must be provided." })
    }

    val initCanvas: (Int, Int) -> Char = { x, y ->
        if (x == 0 || x > height) '-' else if (y == 0 || y > width) '|' else ' '
    }

    val canvas: Array<Array<Char>> = Array(height + 2) { i -> Array(width + 2) { j -> initCanvas(i, j) } }

}

fun main(args: Array<String>) {
    val canvasContext = CanvasContext(height = 4, width = 20)
    val canvas = canvasContext.canvas
    val console = canvas.joinToString(separator = "") { it.toCharArray().joinToString(separator = "", postfix = "\n") { it.toString() } }
    print(console)
}