package pl.coderstrust.christmas;

public class ChristmasTreeForTest {

  public static String[] createChristmasTree(int size) {
    String[] christmasTree = new String[size];
    for (int i = 0; i < christmasTree.length - 1; i++) {
      christmasTree[i] = printSpaces(size, i) + printStars(i);
    }
    christmasTree[size - 1] = size > 2 ? (printSpaces(size, 1) + "**") : "";
    return christmasTree;
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
    for (int i = 0; i < number; i++) {
      sb.append("**");
    }
    return sb.toString();
  }
}
