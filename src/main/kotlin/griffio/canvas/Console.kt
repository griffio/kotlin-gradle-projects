package griffio.canvas

import java.io.InputStream
import java.util.Scanner
import java.util.InputMismatchException
import kotlin.system.exitProcess

class ConsoleException(message: String?) : Exception(message)

class Console {

    var canvas: CanvasContext? = null

    var stroke: Char = 'x'

    fun input(stream: InputStream) {

        val scan = Scanner(stream)

        when (scan.next()) {

            "canvas" -> {

                canvas = try {
                    CanvasContext(width = scan.nextInt(), height = scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("Canvas [width] [height]")
                }
            }

            "line" -> {

                val left: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("Line [x1 y1] x2 y2")
                }
                val right: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("Line x1 y1 [x2 y2]")
                }

                canvas?.draw(Line(left, right), stroke) ?: help()

            }

            "rect" -> {

                val left: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("Rectangle [left top] right bottom")
                }
                val right: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("Rectangle left top [right bottom]")
                }

                canvas?.draw(Rectangle(left, right), stroke) ?: help()

            }

            "fill" -> {

                val point: Point = try {
                    Point(scan.nextInt(), scan.nextInt())
                } catch (e: InputMismatchException) {
                    throw ConsoleException("Fill [x y] filling")
                }

                val filler: String = try {
                    scan.next()
                } catch (e: InputMismatchException) {
                    throw ConsoleException("Fill x y [filling]")
                }

                canvas?.fill(point, filler[0]) ?: help()

            }

            "quit" -> {
                exitProcess(0)
            }
            else -> help()
        }

        println(canvas?.render())
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