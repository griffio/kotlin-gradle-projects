package griffio.spelling

import java.net.URL

fun main(args: Array<String>) {

    val url = URL("http://norvig.com/big.txt")

    val maxLine = url.openStream().bufferedReader().useLines { it.maxBy(String::length) }

    println("maxLine = $maxLine")
}
