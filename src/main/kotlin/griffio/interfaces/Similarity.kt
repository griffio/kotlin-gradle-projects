package griffio.interfaces

interface Similarity {
    fun isSimilar(any: Any): Boolean
    fun isNotSimilar(any: Any): Boolean = !isSimilar(any)
}
