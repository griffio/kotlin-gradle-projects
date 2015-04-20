package griffio.traits

trait Similarity {
    fun isSimilar(any: Any): Boolean
    fun isNotSimilar(any: Any): Boolean = !isSimilar(any)
}
