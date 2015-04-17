package griffio.fizzbuzzes.fizzbuzz

fun main(args: Array<String>): Unit {
    for (i in 1..100) {
        println(
                when {
                    i mod 15 == 0 -> "FizzBuzz"
                    i mod 3 == 0 -> "Fizz"
                    i mod 5 == 0 -> "Buzz"
                    else -> "$i"
                }
        )
    }
}