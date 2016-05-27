package griffio.canvas

data class Point(val x: Int, val y: Int) {

    val invalid = { "x and y argument must be greater than zero" }

    init {
        require(x > 0 && y > 0, invalid)
    }

    operator fun unaryMinus(): Point = Point(-x, -y)
    operator fun plus(other: Int): Point = Point(x + other, y + other)
    operator fun minus(other: Int): Point = Point(x - other, y - other)
    operator fun times(other: Int): Point = Point(x * other, y * other)
    operator fun div(other: Int): Point = Point(x / other, y / other)

    operator fun plus(other: Point): Point = Point(x + other.x, y + other.y)
    operator fun minus(other: Point): Point = Point(x - other.x, y - other.y)
    operator fun times(other: Point): Point = Point(x * other.x, y * other.y)
    operator fun div(other: Point): Point = Point(x / other.x, y / other.y)
}