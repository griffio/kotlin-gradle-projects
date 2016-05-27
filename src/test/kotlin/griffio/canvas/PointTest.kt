package griffio.canvas

import org.junit.Test


class PointTest {

    infix fun Any.equals(expected: Any) {
        kotlin.test.assertEquals(expected, this)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Unary Minus`() {
        Point(1, 1).minus(1)
    }

    @Test
    fun ` Plus`() {
        Point(2, 2) equals Point(1, 1).plus(1)
    }

    @Test
    fun `Minus`() {
        Point(1, 1) equals Point(2, 2).minus(1)
    }

    @Test
    fun `Times`() {
        Point(3, 3) equals Point(1, 1).times(3)
    }

    @Test
    fun `Div`() {
        Point(3, 3) equals Point(6, 6).div(2)
    }

    @Test
    fun `Plus Point`() {
        Point(2, 3) equals Point(1, 1).plus(Point(1, 2))
    }

    @Test
    fun `Minus Point`() {
        Point(1, 1) equals Point(2, 3).minus(Point(1, 2))
    }

    @Test
    fun `Times Point`() {
        Point(3, 6) equals Point(1, 2).times(Point(3, 3))
    }

    @Test
    fun `Div Point`() {
        Point(1, 1) equals Point(3, 6).div(Point(3, 6))
    }
}