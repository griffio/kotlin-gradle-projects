package griffio.shop

import org.junit.Test
import kotlin.test.assertEquals

class CalcTest {
    @Test
    fun buy_three_for_two() {

        val total_quantity = 3

        val discount_offer = 3

        val offer_quantity = 2

        val unit_price = 2.00

        val discount_multiplier = total_quantity / discount_offer

        val discount_quantity = (discount_offer - offer_quantity)

        val discount = unit_price.times(discount_quantity).times(discount_multiplier)

        assertEquals(unit_price, discount, "discount is value of a single unit.")
    }

    @Test
    fun buy_three_get_one_free() {

        val total_quantity = 3

        val discount_offer = 3

        val offer_quantity = 1

        val discount_multiplier = discount_offer / offer_quantity

        val unit_price = 2.00

        val discount_quantity = (total_quantity.div(discount_multiplier))

        val discount = unit_price.times(discount_quantity)

        assertEquals(unit_price, discount, "discount is value of a single unit.")
    }

    @Test
    fun buy_two_for_fixed_amount() {

        val total_quantity = 2

        val offer_quantity = 2

        val discount_offer = 5.00

        val unit_price = 3.49

        val discount_quantity = total_quantity.div(offer_quantity).toInt()

        val discount_price = discount_quantity.times(discount_offer)

        val total_price = unit_price * total_quantity

        val total_discount_price = unit_price * total_quantity.mod(2) + discount_price

        val savings = total_price - total_discount_price

        assertEquals(unit_price.times(2).minus(discount_offer), savings, "savings is the difference between total unit price and discounted offer.")
    }
}