package griffio.canvas

import org.junit.Test
import java.util.*

class CommandsTests {

    sealed class Result<out T> {
        class Ok<T>(val value: T) : Result<T>()
        class Error(val error: String) : Result<Nothing>()
    }

    object CommandA {
        fun input(scanner: Scanner): Result<A> {
            try {
                val left = scanner.nextInt()
                val top = scanner.nextInt()
                return Result.Ok<A>(A(Point(left, top)))
            } catch(e: Exception) {
                return Result.Error("expected A left top")
            }
        }
    }

    object CommandB {
        fun input(scanner: Scanner): Result<B> {
            try {
                val left = scanner.nextInt()
                val top = scanner.nextInt()
                val right = scanner.nextInt()
                val bottom = scanner.nextInt()
                return Result.Ok<B>(B(Point(left, top), Point(right, bottom)))
            } catch(e: Exception) {
                return Result.Error("expected: B left top right bottom")
            }
        }
    }

    data class A(val coordinate: Point)
    data class B(val left: Point, val right: Point)

    @Test
    fun testCommand() {

        val input = "A 1 2"

        val scanning = Scanner(input)

        val r = when (scanning.next()) {
            "A" -> CommandA.input(scanning)
            "B" -> CommandB.input(scanning)
            else -> Result.Error("Command not recognized")
        }

        when (r) {
            is Result.Ok<*> -> println(r.value)
            is Result.Error -> println(r.error)
        }
    }
}