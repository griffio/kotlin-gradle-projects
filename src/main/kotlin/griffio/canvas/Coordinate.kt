package griffio.canvas

class Coordinate private constructor(val x: Int, val y: Int) {

    companion object {
        operator fun invoke(x: Int, y: Int): Coordinate {
            if (x < 1 || x < 1) {
                throw IllegalArgumentException("coordinates can't be less than 1")
            }
            return Coordinate(x, y)
        }
    }

    override fun equals(other: Any?) = other is Coordinate && x == other.x && y == other.y
    override fun hashCode() = x * 31 + y
    override fun toString() = "Coordinate(x=$x, y=$y)"

    fun add(other: Coordinate) = invoke(this.x + other.x, this.y + other.y)
}