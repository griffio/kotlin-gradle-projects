package griffio.canvas

import java.io.InputStream
import java.util.*
import kotlin.system.exitProcess

class ConsoleException(message: String?) : Exception(message)

class Console(stroke: Char = 'x') {

    var stroke: Char = stroke
        set(value) {
            if (value == ' ') throw IllegalArgumentException("")
            field = value
        }

    lateinit var canvas: CanvasContext

    fun input(stream: InputStream) {

        val scan = Scanner(stream)

        when (scan.next()) {

            "canvas" -> {

                canvas = try {
                    CanvasContext(width = scan.nextInt(), height = scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("canvas [width] [height]")
                }
            }

            "line" -> {

                val left: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("line [x1 y1] x2 y2")
                }
                val right: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("line x1 y1 [x2 y2]")
                }

                try {
                    canvas.draw(Line(left, right), stroke)
                } catch(e: UninitializedPropertyAccessException) {
                    help()
                }

            }

            "rect" -> {

                val left: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("rectangle [left top] right bottom")
                }
                val right: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("rectangle left top [right bottom]")
                }

                try {
                    canvas.draw(Rectangle(left, right), stroke)
                } catch(e: UninitializedPropertyAccessException) {
                    help()
                }

            }

            "fill" -> {

                val point: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("fill [x y] filling")
                }

                val filler: String = try {
                    scan.next()
                } catch (e: InputMismatchException) {
                    throw ConsoleException("fill x y [filling]")
                }

                try {
                    canvas.fill(point, filler[0])
                } catch(e: UninitializedPropertyAccessException) {
                    help()
                }
            }

            "quit" -> {
                exitProcess(0)
            }
            else -> help()
        }

        println(canvas.render())
    }

    fun help() {
        throw ConsoleException("type: canvas [width] [height] or quit")
    }
}

fun main(args: Array<String>) {

    val console = Console()

    while (true) {
        try {
            console.input(System.`in`)
        } catch(e: Exception) {
            println(e.message)
        }
    }
}