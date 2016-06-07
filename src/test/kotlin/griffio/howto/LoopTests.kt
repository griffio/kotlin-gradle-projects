import org.junit.Test
import kotlin.test.assertTrue

class LoopTests {

    companion object Thing {
        val length = 5
    }

    @Test
    fun `how do I loop expecting a zero based index`() {
        var actual = 0

        repeat(Thing.length) { index ->
            actual = index // can use implicit 'it'
        }

        assertTrue(actual < 5)
    }

    @Test
    fun `how do I loop expecting an ordinal based index`() {
        var actual = 0

        for (index in 1..Thing.length) {
            actual = index
        }

        assertTrue(actual == 5)
    }
}