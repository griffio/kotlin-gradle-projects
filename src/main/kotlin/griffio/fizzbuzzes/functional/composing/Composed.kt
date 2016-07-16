package griffio.fizzbuzzes.functional.composing

fun main(args: Array<String>) {

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")

    println(strings.filter(oddLength))

    compose(::plus1, ::times2)(10).let {
        println("""
        expect 21
        actual $it
        """)
    }

    pipe(::plus1, ::times2)(10).let {
        println("""
        expect 22
        actual $it
        """)
    }
}

fun isOdd(x: Int) = x % 2 != 0

fun length(s: String) = s.length

fun plus1(x: Int) = x.plus(1)

fun times2(x: Int) = x.times(2)

//
fun <F, G, X> compose(f: (F) -> X, g: (G) -> F): (G) -> X {
    return { x -> f(g(x)) }
}

// The forward composition operator lets you ‘pipe’  f g x = g (f x)
fun <F, G, X> pipe(f: (F) -> G, g: (G) -> X): (F) -> X {
    return { x -> g(f(x)) }
}

fun <String, Boolean, Int> composeToPredicate(f: (Int) -> Boolean, g: (String) -> Int): (String) -> Boolean {
    return compose(f, g)
}

//const compose = (f, g) => x => f(g(x))
//const pipe = (f, g) => x => g(f(x))