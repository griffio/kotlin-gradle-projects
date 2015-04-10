package griffio.fizzbuzzes.reverse

import java.nio.charset.StandardCharsets
import java.util.Arrays
import java.util.Scanner

fun main(args: Array<String>) {

    // Escape `in` - reserved word in Kotlin
    val input = Scanner(System.`in`, StandardCharsets.UTF_8.name())

    val inputString = input.next().trim()

    var startIndex = 0
    var endIndex = inputString.length() -1
    val subject = inputString.toCharArray()
    while(startIndex < endIndex) {
        var swap = subject[startIndex]
        subject[startIndex] = subject[endIndex]
        subject[endIndex] = swap
        startIndex ++
        endIndex --
    }

    println("reversed = ${Arrays.toString(subject)}")

}