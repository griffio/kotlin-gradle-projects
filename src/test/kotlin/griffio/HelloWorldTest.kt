package griffio

import org.junit.Test
import kotlin.test.assertEquals

class HelloWorldTest {

    infix fun Any.equals(expected: Any) {
        assertEquals(expected, this)
    }

    fun hello(name: String?): String {
        val output = if (name?.trim().isNullOrEmpty()) "World" else name?.trim()
        return "Hello, $output!"
    }

    @Test
    fun `null, empty, whitespace input must return hello world`() {
        "Hello, World!" equals hello(null)
        "Hello, World!" equals hello("")
        "Hello, World!" equals hello(" ")
    }

    @Test
    fun `input must return hello input`() {
        "Hello, Alice!" equals hello("Alice")
        "Hello, Alice!" equals hello(" Alice ")
    }
}