package pl.coderstrust.christmas;

public class ChristmasTreeForLoop {

  private static void printChristmasTree(int size) {
    for (int i = 1; i <= size; i++) {
      for (int j = 1; j < (size - i + 1); j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= (2 * i - 1); j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    if (size > 2) {
      for (int i = 1; i < size - 1; i++) {
        System.out.print(" ");
      }
      System.out.println("**");
    }
  }
}
