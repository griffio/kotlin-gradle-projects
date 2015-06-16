package griffio.fizzbuzzes;

public class Queens {

  static int all = 255;

  static int count = 0;

  public static void main(String[] args) {

    int ld = 0;
    int cols = 0;
    int rd = 0;

    attempt(ld, cols, rd);

    System.out.println("count = " + count);

  }

  public static void attempt(int ld, int cols, int rd) {

    if (cols == all) {
      count++;
    }

    int pos = ~(ld | cols | rd) & all;
    
    while (pos > 0) {
      int bit = pos & -pos;
      pos = pos - bit;
      attempt((ld | bit) << 1, cols | bit, (rd | bit) >> 1);
    }

  }

}