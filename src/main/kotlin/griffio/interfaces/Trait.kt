package griffio.interfaces

fun main(args: Array<String>) {

    var xy = Point(100, 10)

    fun one() {
        if (xy.isSimilar(xy)) {
            println("is similar")
        }
    }

    fun two() {
        if (xy.isNotSimilar(Point(99, 22))) {
            println("is not similar")
        }
    }

    one()
    two()

    fun three() {
        val securityDoor = SecurityDoor(DoorCloseTimer(0))
    }

}

class DoorCloseTimer(var id: Long) : Timer {

    override fun timerId(id: Long): Long {
        val old = id
        this.id = id
        return old
    }

}