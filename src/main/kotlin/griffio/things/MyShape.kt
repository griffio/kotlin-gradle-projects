package griffio.things

class Shape(val sides: Int) {

  public operator fun iterator() = (1..sides).iterator()

  public inline fun forEach(action: (Int) -> Unit): Unit {
    for (element in this) action(element)
  }
}