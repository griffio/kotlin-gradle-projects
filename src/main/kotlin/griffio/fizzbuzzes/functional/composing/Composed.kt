package griffio.fizzbuzzes.functional.composing

fun main(args: Array<String>) {
    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))
}

fun isOdd(x: Int) = x % 2 != 0

fun length(s: String) = s.length

fun <A, B, C> compose(f: (C) -> B, g: (A) -> C): (A) -> B {
    return { x -> f(g(x)) }
}

fun <String, Boolean, Int> composeToPredicate(f: (Int) -> Boolean, g: (String) -> Int): (String) -> Boolean {
    return compose(f, g)
}