package griffio

import org.junit.Test
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.test.assertEquals
/**
 * Some infix operators
 */
class PathTest {

    infix fun Any.equals(expected: Any) {
        assertEquals(expected, this)
    }

    infix operator fun Path.div(arg: String) = this.resolve(arg)

    @Test
    fun `resolves the path to user preferences`() {
        val dataPath = Paths.get("/data")
        val userPreferences = dataPath / "user" / "preferences.json"
        "/data/user/preferences.json" equals userPreferences.toString()
    }
}