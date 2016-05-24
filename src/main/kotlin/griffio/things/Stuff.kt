package griffio.things

data class Direction(val x: Int, val y: Int)

interface Thing {
    fun move(direction: Direction)
}

val thingy = object : Thing {
    override fun move(direction: Direction) {
        print("moved in ${direction.x}, ${direction.y}")
    }
}

open class Box<T>(t: T) {
    var contents = t
    fun place(to: T) {
    }
}



val word = Box<String>("Word")
val number = Box<Int>(1234)

fun doIt() {
    number.place(11)
}

fun sum(a: Int, b: Int) = a + b

fun getStringLength(obj: Any): Int? {
    if (obj is String && obj.length > 0)
        return obj.length
    return null
}
