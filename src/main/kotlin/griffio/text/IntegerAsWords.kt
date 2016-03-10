package griffio.text

fun main(args : Array<String>) {
    val range = 1..1000

    var result = 0
    range.forEach { result += writeOut(it).countLetters() }

    println("$result letters would be required to write out all the numbers from ${range.start} to ${range.endInclusive} inclusive")
}

fun writeOut(number : Int) : String = when (number) {
    1 -> "one"
    2 -> "two"
    3 -> "three"
    4 -> "four"
    5 -> "five"
    6 -> "six"
    7 -> "seven"
    8 -> "eight"
    9 -> "nine"
    10 -> "ten"
    11 -> "eleven"
    12 -> "twelve"
    13 -> "thirteen"
    15 -> "fifteen"
    18 -> "eighteen"
    in listOf(14, 16, 17, 19) -> writeOut(number % 10) + "teen"
    20 -> "twenty"
    30 -> "thirty"
    40 -> "forty"
    50 -> "fifty"
    80 -> "eighty"
    in listOf(60, 70, 90) -> writeOut(number / 10) + "ty"
    in 21..99 -> writeOut(number / 10 * 10) + "-" + writeOut(number % 10)
    in 100..999 -> writeOut(number / 100) + " hundred" + if (number % 100 == 0) "" else " and " + writeOut(number % 100)
    1000 -> "one thousand"
    else -> throw IllegalArgumentException()
}

fun String.countLetters(): Int {
    return count { !(it == ' ' || it == '-') }
}