package griffio.fizzbuzzes.filtering

import java.util.Locale

fun main(args: Array<String>) {

    fun one(input: List<String>) {

        input filter { it.startsWith("a") } sortBy { it } map { it.toUpperCase(Locale.ROOT) } forEach {
            println(it)
        }

    }

    one(arrayListOf("one", "two", "abc"))

}
