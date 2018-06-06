package pl.coderstrust.multiplication;

public class MultiplicationTable {

  public static void main(String[] args) {
    printStringTable(createIntArray(1));
    System.out.println();
    printStringTable(createIntArray(4));
    System.out.println();
    printStringTable(createIntArray(7));
    System.out.println();
    printStringTable(createIntArray(15));
  }

  public static String[][] createStringTable(int[][] intTable) {
    String[][] stringTable = new String[intTable.length][intTable.length];
    int maxNumber = stringTable.length * stringTable.length;
    for (int i = 0; i < stringTable.length; i++) {
      for (int j = 0; j < stringTable.length; j++) {
        if (intTable[i][j] == 0) {
          stringTable[i][j] = printSpaces(maxNumber, intTable[i][j]) + " ";
        } else {
          stringTable[i][j] = printSpaces(maxNumber, intTable[i][j]) + intTable[i][j];
        }
      }
    }
    return stringTable;
  }

  private static void printStringTable(int[][] intTable) {
    String[][] stringTable = createStringTable(intTable);
    for (int i = 0; i < stringTable.length; i++) {
      for (int j = 0; j < stringTable.length; j++) {
        System.out.print(stringTable[i][j]);
      }
      System.out.println();
    }
  }

  public static int[][] createIntArray(int size) {
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

  private static String printSpaces(int maxNumber, int number) {
    StringBuilder sb = new StringBuilder(" ");
    String maxNumberString = String.valueOf(maxNumber);
    String numberString = String.valueOf(number);
    int countSpaces = maxNumberString.length() - numberString.length();

    for (int i = 1; i <= countSpaces; i++) {
      sb.append(" ");
    }
    return sb.toString();
  }
}
