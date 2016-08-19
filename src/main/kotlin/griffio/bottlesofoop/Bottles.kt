package griffio.bottlesofoop

/**
 * Listing 1.1: Incomprehensibly Concise
 */
class Bottles1a {

  fun song() = verses(99, 0)

  fun verses(hi: Int, lo: Int) = (hi downTo lo).map { n -> verse(n) }.joinToString("\n")

  fun verse(n: Int): String {
    return """${if (n == 0) "No more" else n.toString()} bottle${if (n != 1) "s" else ""} of beer on the wall,
    ${if (n == 0) "no more" else n.toString()} bottle${if (n != 1) "s" else ""} of beer.
    ${if (n > 0) "Take ${if (n > 1) "one" else "it"}" else "Go to the store and buy some more"},
    ${if (n - 1 < 0) "99" else "${if (n - 1 == 0) "no more" else (n - 1).toString()}"} bottle${if (n - 1 != 1) "s" else ""} on beer on the wall."""
  }
}

fun main(args: Array<String>) {
  println(Bottles1a().song())
  println(Bottles1d().song())
}

class Bottles1d {

  fun song() = verses(99, 0)

  fun verses(starting: Int, ending: Int) = (starting downTo ending).map { i -> verse(i).trimIndent() }.joinToString("\n")

  fun verse(number: Int) = when (number) {
    0 -> """
          No more bottles of beer on the wall,
          no more bottles of beer.
          Go to the store and buy some more,
          99 bottles of beer on the wall.
          """
    1 -> """
          1 bottle of beer on the wall,
          1 bottle of beer.
          Take it down and pass it around,
          no more bottles of beer on the wall.
          """
    2 -> """
          2 bottles of beer on the wall,
          2 bottles of beer.
          Take one down and pass it around,
          1 bottle of beer on the wall.
          """
    else -> """
       $number bottles of beer on the wall,
       $number bottles of beer.
       Take one down and pass it around,
       ${number - 1} bottles of beer on the wall.
       """
  }
}