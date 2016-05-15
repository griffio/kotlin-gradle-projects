package griffio

import org.junit.Test
import kotlin.test.assertEquals

class HelloWorldTest {

    infix fun Any.equals(expected: Any) {
        assertEquals(expected, this)
    }

    fun hello(name: String?): String {
        val output = if (name.isNullOrEmpty()) "World" else name
        return "Hello, $output!"
    }

    @Test
    fun helloNoName() {
        "Hello, World!" equals hello("")
        "Hello, World!" equals hello(null)
    }

    @Test
    fun helloSampleName() {
        "Hello, Alice!" equals hello("Alice")
    }

    @Test
    fun helloAnotherSampleName() {
        "Hello, Bob!" equals hello("Bob")
    }
}