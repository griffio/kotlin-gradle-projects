package griffio.canvas

data class Rectangle(val topLeft: Point, val bottomRight: Point) {
    init {
        require(bottomRight.x > topLeft.x && bottomRight.y > topLeft.y, { "Rectangle must have top left and bottom right vertices: $topLeft, $bottomRight" })
    }
}

data class Line(val left: Point, val right: Point) {
    init {
        require(left.x == right.x || left.y == right.y, { "Line must be horizontal or vertical: $left, $right" })
    }
}
