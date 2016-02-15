package griffio.anagrams

import org.junit.Test
import java.io.File
import java.net.URI
import java.util.Arrays
import kotlin.test.assertTrue

class TestAnagrams {

    fun readWordFromUser(): CharArray {
        return "stop".toCharArray()
    }

    fun loadResource(): URI {
        return this.javaClass.getResource("/anagrams.txt").toURI()
    }

    @Test fun user_input_matches() {
        val wordFromUser = readWordFromUser()
        File(loadResource()).forEachLine {
            val wordFromFile = it.toCharArray()
            assertTrue(Arrays.equals(wordFromFile.sortedArray(), wordFromUser.sortedArray()))
        }
    }
}
