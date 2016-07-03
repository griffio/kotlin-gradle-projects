package griffio.things

import java.util.logging.Logger

interface LoggerAware {
    val logger: Logger
}

class LoggerAwareDelegate(val name: String) : LoggerAware {
    override val logger = Logger.getLogger(name)!!
}

class MyClassWithLogging {
    companion object : LoggerAware by LoggerAwareDelegate("MyClassWithLogging")

    fun info() {
        logger.info("Hello")
    }
}