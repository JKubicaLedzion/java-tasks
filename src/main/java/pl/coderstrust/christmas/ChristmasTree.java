package pl.coderstrust.christmas;

public class ChristmasTree {

  public static void main(String[] args) {
    printChristmasTree(1);
    System.out.println();
    printChristmasTree(2);
    System.out.println();
    printChristmasTree(3);
    System.out.println();
    printChristmasTree(4);
    System.out.println();
    printChristmasTree(5);
    System.out.println();
    printChristmasTree(6);
  }

  private static void printChristmasTree(int size) {
    for (int i = 1; i <= size; i++) {
      System.out.println(printSpaces(size, i) + printStars(i));
    }
    System.out.println(size > 2 ? (printSpaces(size, 2) + "**") : "");
  }

  private static String printSpaces(int size, int number) {
    StringBuilder sb = new StringBuilder("");
    for (int i = number; i < size; i++) {
      sb.append(" ");
    }
    return sb.toString();
  }

  private static String printStars(int number) {
    StringBuilder sb = new StringBuilder("*");
    for (int i = 1; i < number; i++) {
      sb.append("**");
    }
    return sb.toString();
  }
}
