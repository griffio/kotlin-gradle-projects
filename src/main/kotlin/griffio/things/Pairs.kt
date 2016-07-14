package griffio.things

fun main(args: Array<String>) {

    val pairs: List<String> = Pair<String, String>("A", "B").toList()

    val toTypedArray: Array<String>

    toTypedArray = pairs.toTypedArray()

    val hashMapOf = hashMapOf(Pair<String, Int>("A", 1), Pair<String, Int>("C", 2))

    println(pairs)
}