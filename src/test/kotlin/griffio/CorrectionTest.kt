package griffio

import kotlin.test.assertEquals
import griffio.spelling.Correction
import org.junit.Test

class CorrectionTest {

    @Test fun corrected_to_transparent() {
        val actual = Correction("/big.txt").correct("transparen")
        assertEquals("transparent", actual, "spelling correct")
    }

    @Test fun corrected_to_uniformity() {
        val actual = Correction("/big.txt").correct("unifermity")
        assertEquals("uniformity", actual, "spelling correct")
    }

}