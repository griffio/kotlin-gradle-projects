package griffio.shop

import org.junit.Test
import kotlin.test.assertEquals

class DiscountTest {

    val threeForOne: Offer = object : Offer {
        override fun value(): Double {
            return 3.div(1).toDouble()
        }
    }

    @Test
    fun quantity_is_zero() {
        val discount = Discount(0, 2.00, threeForOne)
        val savings = discount.savings()
        assertEquals(0.0, savings, "no savings.")
    }

    @Test
    fun quantity_is_one() {
        val discount = Discount(1, 2.00, threeForOne)
        val savings = discount.savings()
        assertEquals(0.0, savings, "no savings.")
    }

    @Test
    fun quantity_is_two() {
        val discount = Discount(2, 2.00, threeForOne)
        val savings = discount.savings()
        assertEquals(0.0, savings, "no savings.")
    }

    @Test
    fun quantity_is_three() {
        val discount = Discount(3, 2.00, threeForOne)
        val savings = discount.savings()
        assertEquals(discount.unitPrice, savings, "discount is value of a single unit.")
    }

    @Test
    fun quantity_is_four() {
        val discount = Discount(4, 2.00, threeForOne)
        val savings = discount.savings()
        assertEquals(discount.unitPrice, savings, "discount is value of a single unit.")
    }

    @Test
    fun quantity_is_six() {
        val discount = Discount(6, 2.00, threeForOne)
        val savings = discount.savings()
        assertEquals(discount.unitPrice.times(2), savings, "discount is two units.")
    }
}