package griffio.fizzbuzzes.fizzbuzz

sealed class FizzBuzzGame(val i: Int) {

  companion object {
    operator fun invoke(i: Int): FizzBuzzGame {
      return when {
        i.mod(15) == 0 -> FizzBuzzGame.FizzBuzz(i)
        i.mod(3) == 0 -> FizzBuzzGame.Fizz(i)
        i.mod(5) == 0 -> FizzBuzzGame.Buzz(i)
        else -> FizzBuzzGame.Digit(i)
      }
    }
  }

  override fun toString() = i.toString()

  class Fizz(i: Int) : FizzBuzzGame(i) {
    override fun toString() = "Fizz"
  }

  class Buzz(i: Int) : FizzBuzzGame(i) {
    override fun toString() = "Buzz"
  }

  class FizzBuzz(i: Int) : FizzBuzzGame(i) {
    override fun toString() = "FizzBuzz"
  }

  class Digit(i: Int) : FizzBuzzGame(i)
}

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

  fun three() {

    (1..100).forEach {
      println(FizzBuzzGame(it))
    }

  }

  fun four() {

    print("Only FizzBuzz")

    (1..100)
        .map { FizzBuzzGame(it) }
        .filter { it is FizzBuzzGame.FizzBuzz }
        .forEach { println("$it on ${it.i}") }
  }

  one()

  two()

  three()

  four()
}


