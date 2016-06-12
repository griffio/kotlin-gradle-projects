package griffio.howto

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ListTests {

    @Test
    fun `How can I view multiple collections as a single collection?`() {
        val a = listOf("A", "B", "C").asSequence() + listOf("D", "E", "F")
        a.forEach { println (it) }
    }

    @Test
    fun `How can I add an element to a single collection?`() {
        val words = listOf<String>()
        val a = arrayListOf("A", "B", "C").apply { add("D") }
        a.forEach { println (it) }
    }

    @Test
    fun `How can I create an empty sequence`() {
        assertTrue(emptySequence<String>().toList().isEmpty())
        assertTrue(sequenceOf<String>().toList().isEmpty())
    }

    @Test
    fun `How can I return x explicitly from lambda`() {

        val expected = listOf(2, 3, 4, 5, 6)

        val actual = (1..5).map { it ->
            val x = it.plus(1)
            print(x)
            return@map x
        }

        assertEquals(expected, actual)
    }

    @Test
    fun `How can I flatten a list of nested lists into a single list`() {

        val given: List<Any> = listOf(1, listOf(2, listOf(3)), 4, 5, listOf(6))

        sequenceOf(given).forEach { print(it);print("end") }

        val expected = listOf(1, 2, 3, 4, 5, 6)

        val actual = anyFlat(given).toList()

        assertTrue(expected.equals(actual))
    }

    fun anyFlat(anyList: List<*>): Sequence<Any?> {
        return anyList.fold(emptySequence<Any?>(), { result, element ->
            return@fold when (element) {
                is List<*> -> result + anyFlat(element)
                else -> result + sequenceOf(element)
            }
        })
    }
}