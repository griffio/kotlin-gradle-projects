package griffio.things

import org.junit.Test
import kotlin.test.assertEquals

class PizzaTests {

    @Test
    fun `must be small Pizza`() {

        val expect = Pizza(PizzaSize.SMALL)

        val given = 1

        val actual = slicesToSize(given)

        assertEquals(expect, actual)
    }

    @Test
    fun `must be medium Pizza`() {

        val expect = Pizza(PizzaSize.MEDIUM)

        val given = 5

        val actual = slicesToSize(given)

        assertEquals(expect, actual)
    }

    @Test
    fun `must be large Pizza`() {

        val expect = Pizza(PizzaSize.LARGE)

        val given = 11

        val actual = slicesToSize(given)

        assertEquals(expect, actual)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `must fail`() {
        slicesToSize(0)
    }
}
