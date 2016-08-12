package griffio.components

import org.junit.*

class PersonTest {

  @Test
  fun printer() {
    Person("Bobert").println().parent("Bob").println()
  }
}