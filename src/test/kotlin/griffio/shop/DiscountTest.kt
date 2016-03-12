package griffio.shop

import org.junit.Test
import kotlin.test.assertEquals

class DiscountTest {

    val threeForOne: Offer = object : Offer {
        override fun value(): Double {
            return 3.div(1).toDouble()
        }

        override fun toString(): String {
            return "3-For-1"
        }
    }

    val tenPercent: Offer = object : Offer {
        override fun value(): Double {
            return 10.0
        }

        override fun toString(): String {
            return "10% off"
        }
    }

    val unitPrice = 2.00

    val discount = MultiBuyDiscount()

    class MultiBuyDiscount : Discount {
        override fun savings(totalQuantity: Int, unitPrice: Double, offer: Offer): Double {
            val offerValue = offer.value()
            val discountedQuantity = totalQuantity.div(offerValue)
            return unitPrice.times(discountedQuantity.toInt())
        }
    }

    class PercentDiscount : Discount {
        override fun savings(totalQuantity: Int, unitPrice: Double, offer: Offer): Double {
            val offerValue = offer.value()
            val discountedQuantity = totalQuantity.div(offerValue)
            return unitPrice.times(discountedQuantity)
        }
    }

    class ConditionalDiscount(var selector: () -> Boolean) : Discount {
        override fun savings(totalQuantity: Int, unitPrice: Double, offer: Offer): Double {
            val offerValue = offer.value()
            val discountedQuantity = totalQuantity.div(offerValue)
            return if (selector()) unitPrice.times(discountedQuantity) else 0.0
        }
    }

    @Test
    fun quantity_is_zero() {

        val savings = discount.savings(0, 2.00, threeForOne)

        assertEquals(0.0, savings, "no savings.")
    }

    @Test
    fun quantity_is_one() {

        val savings = discount.savings(1, 2.00, threeForOne)

        assertEquals(0.0, savings, "no savings.")
    }

    @Test
    fun quantity_is_two() {

        val savings = discount.savings(2, 2.00, threeForOne)

        assertEquals(0.0, savings, "no savings.")
    }

    @Test
    fun quantity_is_three() {

        var expected = unitPrice

        val actual = discount.savings(2, 2.00, threeForOne)

        assertEquals(expected, actual, "discount is one unit.")
    }

    @Test
    fun quantity_is_four() {

        var expected = unitPrice

        val actual = discount.savings(4, 2.00, threeForOne)

        assertEquals((String.format("%.2f.%n", actual)), String.format("%.2f.%n", actual), "discount is one unit.")
    }

    @Test
    fun quantity_is_six() {

        var expected = unitPrice.times(2)

        val actual = discount.savings(6, 2.00, threeForOne)

        assertEquals((String.format("%.2f.%n", expected)), String.format("%.2f.%n", actual), "discount is two units.")
    }

    @Test
    fun ten_percent() {

        val discount = PercentDiscount()

        var expected = unitPrice.times(3).times(0.10)

        val actual = discount.savings(3, 1.99, tenPercent)

        assertEquals((String.format("%.2f.%n", expected)), String.format("%.2f.%n", actual), "discount is three units.")
    }

}