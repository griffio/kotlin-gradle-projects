package griffio.components

class Person(val name: String) {

    val parents :List<String> = arrayListOf()

    constructor(name: String, parent: String) : this (name) {
        parents.plus(parent)
    }

    fun parent(parent: String): Person {
        parents.plus(parent)
        return this
    }
}

fun add() {
    val person = Person("hello", "world").parent("a").parent("aa")
}

