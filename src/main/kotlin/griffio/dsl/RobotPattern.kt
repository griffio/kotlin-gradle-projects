package griffio.dsl

fun payment(func: PaymentRobot.() -> Unit) = PaymentRobot().apply { func() }

class PaymentRobot {
    fun amount(amount: Long) {
        println("Amount $amount")
    }

    fun recipient(recipient: String) {
        println("Hello $recipient")
    }

    infix fun send(func: ResultRobot.() -> Unit) = ResultRobot().apply { func() }
}

class ResultRobot {
    fun isSuccess() { }
}

fun main(args: Array<String>) {

    payment {
        amount(100)
        recipient("bob@example.com")
    } send {
        isSuccess()
    }
}