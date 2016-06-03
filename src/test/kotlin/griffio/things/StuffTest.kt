package griffio.things

import griffio.canvas.*
import org.junit.Test
import kotlin.test.assertTrue

class StuffTest {

    @Test
    fun `Δ`() {
    }

    @Test
    fun `rect`() {
        val r = Rectangle(Point(180, 40), Point(220, 60))

        val c = Coordinate(1, 1)

        print(c)

        print(c.add(Coordinate(2, 2)))

        assertTrue(Coordinate(1, 2).hashCode().equals(Coordinate(1, 2).hashCode()))

        print(Point(1, 1))

        assertTrue(Point(1, 2).hashCode().equals(Point(1, 2).hashCode()))

        Point(1, 1)
    }

    @Test
    fun `line`() {
        val l = Line(Point(1, 2), Point(1, 4))
        val r = Rectangle(Point(16, 1), Point(20, 3))
    }
}