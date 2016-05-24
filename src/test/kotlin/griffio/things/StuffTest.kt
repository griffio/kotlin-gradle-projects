package griffio.things

import griffio.canvas.Coordinate
import griffio.canvas.Point
import griffio.canvas.Rect
import griffio.canvas.Triangle
import org.junit.Test
import kotlin.test.assertTrue

class StuffTest {

    @Test
    fun `Δ`() {
        val t = Triangle(347, 54, 392, 9, 392, 66)
    }

    @Test
    fun `rect`() {
        val r = Rect(180, 60, 220, 40)

        val c = Coordinate(1, 1)

        print(c)

        print(c.add(Coordinate(2, 2)))

        assertTrue(Coordinate(1, 2).hashCode().equals(Coordinate(1, 2).hashCode()))

        print(Point(1, 1))

        assertTrue(Point(1, 2).hashCode().equals(Point(1, 2).hashCode()))

        Point(1, 0)
    }
}