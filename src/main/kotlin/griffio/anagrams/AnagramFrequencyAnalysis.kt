package griffio.anagrams

import java.nio.charset.StandardCharsets
import java.util.Arrays
import java.util.Scanner

fun main(args: Array<String>) {

    // Escape `in` - reserved word in Kotlin
    val input = Scanner(System.`in`, StandardCharsets.UTF_8.name())

    val testCases = input.nextInt()

    for (x in 1..testCases) {

        val ab = input.next()

        var changes: Int = -1

        if (ab.length().mod(2) == 0) {
            val partition = ab.length() / 2;
            changes = partition
            val a: CharArray = ab.substring(0, partition).toCharArray()
            val b: CharArray = ab.substring(partition).toCharArray()
            a.sort()
            b.sort()
            for (pair in a.zip(b.asIterable())) {
                if (pair.first.equals(pair.second)) changes.minus()
            }
        }

        System.out.println(changes)

    }

}