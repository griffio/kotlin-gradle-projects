package griffio

import org.junit.Test
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.test.assertEquals

class PathTest {

    infix operator fun Path.div(arg: String) = this.resolve(arg)

    @Test
    fun `resolves the path to user preferences`() {
        val dataPath = Paths.get("/data")
        val userPreferences = dataPath / "user" / "preferences.json"
        assertEquals("/data/user/preferences.json", userPreferences.toString())
    }

}