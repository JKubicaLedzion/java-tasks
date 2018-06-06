package pl.coderstrust.pascal;

import java.util.Arrays;

public class PascalTriangle {

  public String[] createPascalTriangle(int size) {
    String[] pascalTriangle = new String[size];

    for (int i = 1; i <= pascalTriangle.length; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(printSpaces(size, i));
      for (int j = 1; j <= i; j++) {
        sb.append(printNumberRecursive(i, j) + " ");
      }
      pascalTriangle[i - 1] = sb.toString();
    }
    return pascalTriangle;
  }

  private void printTriangle(String[] pascalTriangle) {
    Arrays.stream(pascalTriangle).forEach(System.out::println);
  }

  private String printSpaces(int size, int number) {
    StringBuilder sb = new StringBuilder("");
    for (int i = number; i < size; i++) {
      sb.append(" ");
    }
    return sb.toString();
  }

  private int printNumberRecursive(int i, int j) {
    if (j == 1 || j == i) {
      return 1;
    }
    return printNumberRecursive(i - 1, j - 1) + printNumberRecursive(i - 1, j);
  }
}
