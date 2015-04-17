package griffio.fizzbuzzes;

public class Fizzbuzz {

  public static void main(String[] args) {

    StringBuilder result = new StringBuilder();

    for (int i = 1; i <= 100; i++) {
      if (i % 15 == 0) {
        result.append("FizzBuzz");
      } else if (i % 3 == 0) {
        result.append("Fizz");
      } else if (i % 5 == 0) {
        result.append("Buzz");
      } else {
        result.append(i);
      }
      result.append("\n");
    }
    if (result.toString().equals(new Fizzbuzz().asString())) {

      System.out.print("Same");

    }

  }

  public String asString() {

    StringBuilder result = new StringBuilder();

    for (int i = 1; i <= 100; i++) {

      boolean fizz = i % 3 == 0;
      boolean buzz = i % 5 == 0;
      boolean fizzbuzz = fizz && buzz;

      if (fizzbuzz) {
        result.append("FizzBuzz");
      } else if (fizz) {
        result.append("Fizz");
      } else if (buzz) {
        result.append("Buzz");
      } else {
        result.append(i);
      }

      result.append("\n");
    }

    return result.toString();

  }

}