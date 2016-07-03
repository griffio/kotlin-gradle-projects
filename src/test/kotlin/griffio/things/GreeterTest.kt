package griffio.things

import org.jetbrains.spek.api.Spek
import kotlin.test.assertEquals

class GreetingTest : Spek({
    describe("a greeting") {
        it("uses default greeting") {
            assertEquals(Greeter.greeting(), "Hello World!")
        }

        it("uses be the input") {
            assertEquals(Greeter.greeting("OK"), "OK")
        }
    }
})