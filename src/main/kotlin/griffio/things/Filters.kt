package griffio.things

val values = listOf("One", "Two", "Three", "Four")

fun getFirstOrNull(id: String): String? {
    for (value in values) {
        if (value.equals(id)) {
            return value;
        }
    }
    return null
}

fun main(args: Array<String>) {

    val id = "Three"

    val value0 = getFirstOrNull(id)

    val value1 = values.firstOrNull() { it == id }

    println(value0)
    println(value1)
}
