package griffio.shop

data class Shop(var order: Order)

data class Savings(val offer: Offer, val discount: Discount, val sum: Double = 0.0) {
    fun accumulate(sum: Double): Savings {
        return this
    }
}

fun order(vararg products: Product) = Order(products.toList())

interface Offer {
    fun value(): Double
}

interface Discount {
    fun savings(totalQuantity: Int, unitPrice: Double, offer: Offer): Double
}

fun Shop.getTotalOrderBalance(): Double = order.products.sumByDouble { it.price }

fun Shop.applyDiscounts(discounts: Set<Discount>): Double = discounts.sumByDouble { return 0.0 }

data class Order(val products: List<Product>)

data class OrderLine(val product: Product, val quantity: Int)

data class Product(val name: String, val price: Double, val sku: ProductSku) {
    override fun toString() = "$name $price $sku"
}

data class ProductSku(val code: String)
