package griffio.fizzbuzzes.filtering

import java.util.Locale

fun main(args: Array<String>) {

    fun one(input: List<String>) {

        input.filter { it.startsWith("a") }.sortedBy { it }.map { it.toUpperCase(Locale.ROOT) }.forEach {
            println(it)
        }

    }
    //ABC
    //CBA
    one(arrayListOf("cba", "one", "two", "abc"))

}
