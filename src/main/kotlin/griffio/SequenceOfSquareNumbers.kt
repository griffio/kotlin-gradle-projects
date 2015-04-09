package griffio

import java.nio.charset.StandardCharsets
import java.util.Scanner

fun main(args: Array<String>) {

    // Escape `in` - reserved word in Kotlin
    val input = Scanner(System.`in`, StandardCharsets.UTF_8.name())

    val testCases = input.nextInt()

    for(x in 1..testCases) {

        val a = input.nextInt()
        val b = input.nextInt()

        var count: Int = 0

        for(y in a..b) {

            val sqrt = Math.sqrt(y.toDouble()).toInt()

            if (sqrt * sqrt == y) {
                count ++
            }

        }

        System.out.println(count)

    }

}
