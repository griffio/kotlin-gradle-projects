package griffio.canvas

data class Point(val x: Int, val y: Int) {

    val invalid = { "x and y argument must be greater than zero" }

    init {
        require(x > 0 && y > 0, invalid)
    }
}