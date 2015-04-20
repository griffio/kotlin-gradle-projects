package griffio.traits

class SecurityDoor(timer : Timer) : Doorway, Timer by timer {

    override fun isOpen(): Boolean {
        return true
    }
}