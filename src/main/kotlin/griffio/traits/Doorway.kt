package griffio.traits

public trait Doorway {
    fun isOpen() : Boolean
    fun isClosed() : Boolean = !isOpen()
}