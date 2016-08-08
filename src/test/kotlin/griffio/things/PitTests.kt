package griffio.things

import org.junit.Assert
import org.junit.Test

class PitTests {

  @Test
  fun `given must be return "Hello World"`() {
     val given = "Hello World"
     val expected = given
     val actual = Greeter.greeting(given)
     Assert.assertEquals(expected, actual)
  }

  @Test
  fun `null must return "Hello World!"`() {
     val given = null
     val expected = "Hello World!"
     val actual = Greeter.greeting(given)
     Assert.assertEquals(expected, actual)
  }

  @Test
  fun `blank input must return "Hello World!"`() {
     val given = ""
     val expected = "Hello World!"
     val actual = Greeter.greeting(given)
     Assert.assertEquals(expected, actual)
  }

  @Test
  fun `must return given "Hello World was here"`() {
     val given = "Hello World"
     val expected = "$given was here"
     val actual = Greeter.badGreet(given)
     Assert.assertEquals(expected, actual)
  }
}