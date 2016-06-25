import griffio.railroading.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.asserter

class RailRoadPatternKtTest {

    infix fun Any.equals(expected: Any) {
        assertEquals(expected, this)
    }

    @Test
    fun `email and name must not be blank`() {

        val given = Request(email = "hamilton@example.com", name = "Hamilton")
        val actual = bind(emailCheck, nameCheck(given))

        when (actual) {
            is Result.Success<Request> -> actual.value equals given
            else -> asserter.fail("expected success")
        }
    }

    @Test
    fun `name must not be blank`() {

        val given = Request(email = "hamilton@example.com", name = "")
        val actual = bind(nameCheck, emailCheck(given))

        when (actual) {
            is Result.Failure<String> -> actual equals nameBlank
            else -> asserter.fail("expected failure")
        }
    }

    @Test
    fun `email must not be blank`() {

        val given = Request(email = "", name = "Hamilton")
        val actual = bind(nameCheck, emailCheck(given))

        when (actual) {
            is Result.Failure<String> -> actual equals emailBlank
            else -> asserter.fail("expected failure")
        }
    }
}