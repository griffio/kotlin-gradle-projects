package griffio.fizzbuzzes.filtering

import java.util.Locale

fun main(args: Array<String>) {

    fun one(input: Array<String>) {

        input filter { it.startsWith("a") } sortBy { it } map { it.toUpperCase(Locale.ROOT) } forEach {
            println(it)
        }

    }

    one(array("one", "two", "abc"))

}
