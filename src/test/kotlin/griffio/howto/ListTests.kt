package griffio.howto

import org.junit.Test
import kotlin.test.assertTrue

class ListTests {

    @Test
    fun `How can I view multiple collections as a single collection?` () {
        val a = listOf("A", "B", "C").asSequence() + listOf("D", "E", "F")
        a.forEach { println (it) }
    }

    @Test
    fun `How can I add an element to a single collection?` () {
        val words = listOf<String>()
        val a = arrayListOf("A", "B", "C").apply { add("D") }
        a.forEach { println (it) }
    }

    @Test
    fun `How can I create an empty sequence` () {
        assertTrue(emptySequence<String>().toList().isEmpty())
        assertTrue(sequenceOf<String>().toList().isEmpty())
    }
}