package griffio.shop

import org.junit.Test
import kotlin.test.assertEquals

class ShopTest {

    val sumoTangerines = Product("Sumo Tangerines", 5.99, ProductSku("SKU-0947"))

    val plasticSpoons = Product("Plastic Spoons", 7.99, ProductSku("SKU-1002"))

    val aloeVera = Product("Aloe Vera", 1.99, ProductSku("SKU-1112"))

    val lobsterMacCheese = Product("Lobster Mac & Cheese", 5.50, ProductSku("SKU-331"))

    var order = order(sumoTangerines, aloeVera, plasticSpoons, lobsterMacCheese)

    @Test
    fun order_balance() {

        var expected = listOf(sumoTangerines, aloeVera, plasticSpoons, lobsterMacCheese).sumByDouble { it.price }

        val shopping = Shop(order)

        val actual = shopping.getTotalOrderBalance()

        assertEquals((String.format("%.2f.%n", expected)), String.format("%.2f.%n", actual))
    }
}
