package griffio.things

data class Line(val x1: Int, val y1: Int,
                val x2: Int, val y2: Int)

data class Triangle(val x1: Int, val y1: Int,
                    val x2: Int, val y2: Int,
                    val x3: Int, val y3: Int)

data class Quad(val x1: Int, val y1: Int,
                val x2: Int, val y2: Int,
                val x3: Int, val y3: Int,
                val x4: Int, val y4: Int)

data class Rect(val x: Int, val y: Int,
                val width: Int, val height: Int)

data class Ellipse(val x: Int, val y: Int,
                   val width: Int, val height: Int)

data class Arc(val x: Int, val y: Int,
               val width: Int, val height: Int,
               val start: Int, val stop: Int)

data class Direction(val x: Int, val y: Int)

interface Thing {
    fun move(direction: Direction)
}

val thingy = object : Thing {
    override fun move(direction: Direction) {
        print("moved in ${direction.x}, ${direction.y}")
    }
}
