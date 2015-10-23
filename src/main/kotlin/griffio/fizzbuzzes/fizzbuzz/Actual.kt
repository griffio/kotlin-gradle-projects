package griffio.fizzbuzzes.fizzbuzz

fun main(args: Array<String>): Unit {

    fun one() {

        for (i in 1..100) {
            println(
                    when {
                        i.mod(15) == 0 -> "FizzBuzz"
                        i.mod(3) == 0 -> "Fizz"
                        i.mod(5) == 0 -> "Buzz"
                        else -> "$i"
                    }
            )
        }

    }


    fun two() {

        for (i in 1..100) {
            println(
                    if (i % 15 == 0) "FizzBuzz"
                    else if (i % 3 == 0) "Fizz"
                    else if (i % 5 == 0) "Buzz"
                    else i.toString())
        }
    }

    one()

    two()

}