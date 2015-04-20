package griffio.traits

class Point(val x: Int, val y: Int) : Similarity {
    
    override fun isSimilar(any: Any): Boolean = when (any) {
        is Point -> x == any.x
        else -> false
    }

}
