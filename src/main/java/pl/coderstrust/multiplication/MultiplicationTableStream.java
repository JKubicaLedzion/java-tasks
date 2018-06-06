package pl.coderstrust.multiplication;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiplicationTableStream {

  public static void main(String[] args) {
    printMultiplicationTable(createArray(1));
    System.out.println();
    printMultiplicationTable(createArray(4));
    System.out.println();
    printMultiplicationTable(createArray(10));
    System.out.println();
    printMultiplicationTable(createArray(33));
  }

  private static void printMultiplicationTable(int[][] array) {
    int maxNumber = array.length * array.length;

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (array[i][j] == 0) {
          System.out.print(printSpacesStream(maxNumber, array[i][j]) + " ");
        } else {
          System.out.print(printSpacesStream(maxNumber, array[i][j]) + array[i][j]);
        }
      }
      System.out.println();
    }
  }

  public static String[][] createStringTable(int[][] intTable) {
    String[][] stringTable = new String[intTable.length][intTable.length];
    int maxNumber = stringTable.length * stringTable.length;
    for (int i = 0; i < stringTable.length; i++) {
      for (int j = 0; j < stringTable.length; j++) {
        if (intTable[i][j] == 0) {
          stringTable[i][j] = printSpacesStream(maxNumber, intTable[i][j]) + " ";
        } else {
          stringTable[i][j] = printSpacesStream(maxNumber, intTable[i][j]) + intTable[i][j];
        }
      }
    }
    return stringTable;
  }

  public static int[][] createArray(int size) {
    int[][] array = new int[size + 1][size + 1];
    for (int i = 1; i < array.length; i++) {
      array[0][i] = i;
      array[i][0] = i;
    }

    for (int i = 1; i < array.length; i++) {
      for (int j = 1; j < array.length; j++) {
        array[i][j] = i * j;
      }
    }
    return array;
  }

  private static String printSpacesStream(int maxNumber, int number) {
    return " "
        + IntStream
            .range(1, String.valueOf(maxNumber).length() - String.valueOf(number).length() + 1)
            .mapToObj(i -> new String(" "))
            .collect(Collectors.joining());
  }
}
