package griffio.shop



interface Shop {
    fun checkout(order: Order) {
        order.lines
    }
}

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

fun Shop.getTotalOrderPrice(order: Order): Double = order.lines.sumByDouble { it.product.price.times(it.product.price) }

data class Order(val lines: List<OrderLine>)

data class OrderLine(val product: Product, val quantity: Int)

data class Product(val name: String, val price: Double, val sku: ProductSku) {
    override fun toString() = "$name $price $sku"
}

data class ProductSku(val code: String)
