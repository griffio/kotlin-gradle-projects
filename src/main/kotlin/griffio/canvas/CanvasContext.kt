package griffio.canvas

class CanvasContext(val height: Int, val width: Int) {

    init {
        require(height > 0 && width > 0, { "a non zero height and width must be provided." })
    }

    val initCanvas: (Int, Int) -> Char = { x, y ->
        if (x == 0 || x > height) '-' else if (y == 0 || y > width) '|' else ' '
    }

    val canvas: Array<Array<Char>> = Array(height + 2) { i -> Array(width + 2) { j -> initCanvas(i, j) } }

    private fun draw(x1: Int, y1: Int, x2: Int, y2: Int, stroke: Char) {
        for (y in y1..y2) {
            for (x in x1..x2) {
                if (canFill(x, y)) canvas[y][x] = stroke
            }
        }
    }

    fun draw(line: Line, stroke: Char): CanvasContext {
        draw(line.left.x, line.left.y, line.right.x, line.right.y, stroke)
        return this
    }

    fun draw(rect: Rectangle, stroke: Char): CanvasContext {
        draw(rect.topLeft.x, rect.topLeft.y, rect.bottomRight.x, rect.topLeft.y, stroke)
        draw(rect.topLeft.x, rect.topLeft.y, rect.topLeft.x, rect.bottomRight.y, stroke)
        draw(rect.topLeft.x, rect.bottomRight.y, rect.bottomRight.x, rect.bottomRight.y, stroke)
        draw(rect.bottomRight.x, rect.topLeft.y, rect.bottomRight.x, rect.bottomRight.y, stroke)
        return this
    }

    fun canFill(x: Int, y: Int): Boolean {
        return !(x == 0
                || y == 0
                || x > width
                || y > height
                || canvas[y][x].isLetterOrDigit())
    }

    fun fill(x: Int, y: Int, stroke: Char) {
        if (canFill(x, y)) {
            canvas[y][x] = stroke
            fill(x + 1, y, stroke)
            fill(x - 1, y, stroke)
            fill(x, y + 1, stroke)
            fill(x, y - 1, stroke)
        }
    }

    fun fill(point: Point, filler: Char): CanvasContext {
        fill(point.x, point.y, filler)
        return this
    }

    fun render(): CharSequence {
        return canvas.joinToString(separator = "") { it.toCharArray().joinToString(separator = "", postfix = "\n") { it.toString() } }
    }
}

fun main(args: Array<String>) {
    val canvasContext = CanvasContext(width = 20, height = 4)
    canvasContext.draw(Line(Point(1, 2), Point(6, 2)), 'x')
    canvasContext.draw(Line(Point(6, 3), Point(6, 4)), 'x')
    canvasContext.draw(Rectangle(Point(16, 1), Point(20, 3)), 'x')
    canvasContext.fill(Point(10, 3), 'o')
    print(canvasContext.render())
}