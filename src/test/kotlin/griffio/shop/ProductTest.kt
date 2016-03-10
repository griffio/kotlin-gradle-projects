package griffio.shop

import org.junit.Test
import kotlin.test.assertEquals

class ProductTest {

    val threeForOne: Offer = object : Offer {
        override fun value(): Double {
            return 3.div(1).toDouble()
        }
    }

    val sumoTangerines = Product("Sumo Tangerines", 5.99, ProductSku("SKU-0947"))

    val plasticSpoons = Product("Plastic Spoons", 7.99, ProductSku("SKU-1002"))

    val aloeVera = Product("Aloe Vera", 1.99, ProductSku("SKU-1112"))

    @Test
    fun three_for_one_savings() {

        val basket = listOf(sumoTangerines, plasticSpoons, aloeVera, aloeVera, aloeVera).groupBy { it }

        val savings = basket.map { Discount(it.value.size, it.key.price, threeForOne).savings() }.reduce { total, saving  -> total.plus(saving) }

        assertEquals(aloeVera.price, savings)
    }
}