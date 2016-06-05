package griffio.things

data class Pizza(val pizza: PizzaSize)

enum class PizzaSize {
    SMALL,
    MEDIUM,
    LARGE
}

fun slicesToSize(slices: Int):Pizza {
    val size = when(slices) {
        in 1..4 -> PizzaSize.SMALL
        in 5..8 -> PizzaSize.MEDIUM
        in 9..12 -> PizzaSize.LARGE
        else -> throw IllegalArgumentException("We don't sell a pizza like that. Try 1 to 12 slices.")
    }
    return Pizza(size)
}
