package griffio.canvas

import java.io.InputStream
import java.util.*
import kotlin.system.exitProcess

sealed class ConsoleResult<out T> {
    class Ok<T>(val value: T) : ConsoleResult<T>()
    class Error(val error: String) : ConsoleResult<Nothing>()
}

class ConsoleException(message: String?) : Exception(message)

class Console(val stroke: Char = 'x') {

    private var _canvas: CanvasContext? = null

    private val canvas: CanvasContext
        get() = _canvas ?: help()

    fun input(stream: InputStream) {

        val scan = Scanner(stream)

        when (scan.next()) {

            "canvas" -> {
                _canvas = try {
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

                canvas.draw(Line(left, right), stroke)
            }

            "rect" -> {

                val left: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("invalid point -> [left top] right bottom")
                }
                val right: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("left top [right bottom] <-invalid point")
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

                canvas.fill(point, filler[0])
            }

            "quit" -> {
                exitProcess(0)
            }
            else -> help()
        }

        println(canvas.render())
    }

    fun help(): CanvasContext {
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