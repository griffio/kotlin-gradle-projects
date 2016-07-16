package griffio.things

// extra fields are not included in hashcode/equals

data class Pizza(val pizza: PizzaSize) {
    val description: String = "This is a %s pizza"
        get() = field.format(pizza)

    companion object {
        @JvmField val serialVersionUID: Long = 42L
    }
}

enum class PizzaSize {
    SMALL,
    MEDIUM,
    LARGE
}

fun slicesToSize(slices: Int): Pizza {
    val size = when (slices) {
        in 1..4 -> PizzaSize.SMALL
        in 5..8 -> PizzaSize.MEDIUM
        in 9..12 -> PizzaSize.LARGE
        else -> throw IllegalArgumentException("We don't sell a pizza like that. Try 1 to 12 slices.")
    }
    return Pizza(size)
}