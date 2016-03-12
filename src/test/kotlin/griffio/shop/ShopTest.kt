package griffio.shop

import org.junit.Test
import kotlin.test.assertEquals

class ShopTest {

    val buyOneGetOneFree: Offer = object : Offer {
        override fun value(): Double {
            return 2.div(1).toDouble()
        }
    }

    fun strings(build: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        sb.build()
        return sb.toString()
    }

    val sumoTangerines = Product("Sumo Tangerines", 5.99, ProductSku("SKU-0947"))

    val plasticSpoons = Product("Plastic Spoons", 7.99, ProductSku("SKU-1002"))

    val aloeVera = Product("Aloe Vera", 1.99, ProductSku("SKU-1112"))

    val lobsterMacCheese = Product("Lobster Mac & Cheese", 5.50, ProductSku("SKU-331"))

    val blueBerries = Product("Blue Berries 200g", 2.00, ProductSku("SKU-BB200"))

    val oliveCiabatta = Product("Olive Ciabatta", 1.65, ProductSku("SKU-L1022"))

    var order = order(sumoTangerines, aloeVera, plasticSpoons, lobsterMacCheese)

    @Test
    fun order_balance() {

        var expected = listOf(sumoTangerines, aloeVera, plasticSpoons, lobsterMacCheese).sumByDouble { it.price }

        val shopping = Shop(order)

        val actual = shopping.getTotalOrderBalance()

        assertEquals((String.format("%.2f%n", expected)), String.format("%.2f%n", actual))
    }

    @Test
    fun print_order_balance() {

        val expected = listOf(blueBerries, oliveCiabatta, oliveCiabatta)

        val shopping = Shop(Order(expected))

        val multiBuyDiscount = DiscountTest.MultiBuyDiscount()

        val productSavings = expected
                .groupBy { it }
                .mapValues { multiBuyDiscount.savings(it.value.size, it.key.price, buyOneGetOneFree) }
                .filter { it.value > 0 }

        val s = strings {
            appendln("Receipt:-\n")
            expected.map {
                append(String.format("%-25s $%.2f%n", it.name, it.price))
            }
            appendln(String.format("%-25s $%.2f%n", "${expected.size} BALANCE DUE", shopping.getTotalOrderBalance()))

            if (productSavings.size > 0) {
                appendln("OFFERS")

               for((product, savings) in productSavings) {
                    append(String.format("%-25s $%.2f%n", product.name, savings))
                }

                appendln(String.format("%-25s $%.2f%n", "YOU SAVE ", productSavings.values.sumByDouble { it }))
            }
        }

        println(s)
    }
}
