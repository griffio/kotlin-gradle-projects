package griffio.interfaces

public interface Doorway {
    fun isOpen() : Boolean
    fun isClosed() : Boolean = !isOpen()
}