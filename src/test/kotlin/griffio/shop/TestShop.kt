package griffio.shop

import org.junit.Test
import kotlin.test.assertEquals

class TestShop {
    @Test
    fun buy_three_get_one_free() {

        val total_quantity = 3

        val discount_offer = 3.div(1)

        val unit_price = 2.00

        val discount_quantity = (total_quantity.div(discount_offer))

        val discount = unit_price.times(discount_quantity.toInt())

        assertEquals(unit_price, discount, "discount is value of a single unit.")
    }

    @Test
    fun buy_two_for_fixed_amount() {

        val total_quantity = 2

        val discount_offer = 5.00

        val unit_price = 3.49

        val discount_quantity = total_quantity.div(2).toInt()

        val discount_price = discount_quantity.times(discount_offer)

        val total_price = unit_price * total_quantity

        val total_discount_price = unit_price * total_quantity.mod(2) + discount_price

        val savings = total_price - total_discount_price

        assertEquals(unit_price.times(2).minus(discount_offer), savings, "savings is the difference between total unit price and discounted offer.")

    }
}