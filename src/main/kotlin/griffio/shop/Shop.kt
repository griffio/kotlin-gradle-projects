package griffio.shop

data class Shop(var order: Order)

fun order(vararg products: Product) = Order(products.toList())

interface Offer {
    fun value(): Double
}

open class Discount(val totalQuantity: Int, val unitPrice: Double, val offer: Offer) {

    val offerValue = offer.value()

    val discountedQuantity = totalQuantity.div(offerValue)

    open fun savings(): Double {
        return unitPrice.times(discountedQuantity.toInt())
    }
}

fun Shop.getTotalOrderBalance(): Double = order.products.sumByDouble { it.price }

fun Shop.applyDiscounts(discounts: Set<Discount>): Double = discounts.sumByDouble { it.savings() }

data class Order(val products: List<Product>)

data class OrderLine(val product: Product, val quantity: Int)

data class Product(val name: String, val price: Double, val sku: ProductSku) {
    override fun toString() = "$name $price $sku"
}

data class ProductSku(val code: String)
