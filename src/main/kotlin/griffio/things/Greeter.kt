package griffio.things

object Greeter{
    fun greeting(message: String? = null): String {
        return "${if (message.isNullOrBlank()) "Hello World!" else message}"
    }
}

fun main(args: Array<String>) {
    Greeter.greeting()
}