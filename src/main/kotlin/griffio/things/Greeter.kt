package griffio.things

object Greeter{
    fun greeting(message: String? = null): String {
        return "${if (message.isNullOrBlank()) "Hello World!" else message}"
    }

    fun badGreet(message: String? = null) : String {
        return "$message was here"
    }
}

fun main(args: Array<String>) {
    Greeter.greeting()
}