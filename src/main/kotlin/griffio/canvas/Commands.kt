package griffio.canvas

import java.util.Scanner

interface Command

class Quit() : Command {
}

class Unknown(val any: String) : Command

data class Line(val x1: Int, val y1: Int,
                val x2: Int, val y2: Int) : Command

data class Triangle(val x1: Int, val y1: Int,
                    val x2: Int, val y2: Int,
                    val x3: Int, val y3: Int) : Command

data class Quad(val x1: Int, val y1: Int,
                val x2: Int, val y2: Int,
                val x3: Int, val y3: Int,
                val x4: Int, val y4: Int) : Command

data class Rect(val x: Int, val y: Int,
                val width: Int, val height: Int) : Command

data class Ellipse(val x: Int, val y: Int,
                   val width: Int, val height: Int) : Command

data class Arc(val x: Int, val y: Int,
               val width: Int, val height: Int,
               val start: Int, val stop: Int) : Command

data class Canvas(val x: Int, val y: Int) : Command {

    val invalid = { "x and y argument must be greater than zero" }

    init {
        require(x > 0 && y > 0, invalid)
    }

}

val height = 4
val width = 20
val initData: (Int, Int) -> Char = {x, y -> ' '}
val data: Array<Array<Char>> = Array(height) { i -> Array(width) { j -> initData(i, j) } }

fun input(line: String): Command {

//    array.forEachIndexed { i, it -> for (j in it.indices) it[j] = 1 + i + j } // fill

    val scan = Scanner(line)
    val command = scan.next()

    return when (command) {

        "Canvas" -> {
            Canvas(scan.nextInt(), scan.nextInt())
        }

        "Line" -> {
            Line(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt())
        }

        "Rect" -> {
            Rect(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt())
        }

        "Quit" -> {
            Quit()
        }

        else -> {
            Unknown(command)
        }
    }
}

fun main(args: Array<String>) {

    input("Quit")
    input("Canvas 1 2")
    input("Line 1 2 1 5")
    val input = input("Rect 1 2 4 1")

    print(input)

}