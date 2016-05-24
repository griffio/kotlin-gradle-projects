package griffio

object Configurations {
    val variant: String = "android"
}

fun Unit.exhaustive() : Unit {}

class X {

}

fun dependencies(body: Configurations.() -> Unit) {
    Configurations.body()

}

val d = dependencies {

}.exhaustive()


class Example() {
    companion  object
    {
        fun create() = Example()
    }
}

fun demo() {
    val e = Example.create()
}