package pl.coderstrust.christmas;

import static org.apache.commons.lang3.StringUtils.center;

public class ChristmasTreeStringBuilder {

  private static void printChristmasTree(int size) {
    int consoleSize = size * 2 - 1;
    for (int i = 1; i <= size; i++) {
      System.out.println(center(printStars(i), consoleSize));
    }
    System.out.println(size > 2 ? (center("**", consoleSize)) : "");
  }

  private static String printStars(int number) {
    StringBuilder sb = new StringBuilder("*");
    for (int i = 1; i < number; i++) {
      sb.append("**");
    }
    return sb.toString();
  }
}
