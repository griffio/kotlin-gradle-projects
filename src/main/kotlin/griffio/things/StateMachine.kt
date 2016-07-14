package griffio.things

sealed class Connection() {

    object New : Connection()

    fun connect(): Connected {
        return Connected()
    }

    class Disconnected() {
        fun connect(): Connected {
            return Connected()
        }
    }

    class Connected() {
        fun disconnect(): Disconnected {
            return Disconnected()
        }
    }
}

fun main(args: Array<String>) {
    val initial: Connection.New = Connection.New
    var connected: Connection.Connected = initial.connect()
    val disconnected = connected.disconnect()
    connected = disconnected.connect()
}