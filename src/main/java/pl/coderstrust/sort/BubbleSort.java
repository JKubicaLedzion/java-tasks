package pl.coderstrust.sort;

import java.util.Arrays;

public class BubbleSort implements SortingMethod {

  @Override
  public int[] sort(int[] array) {
    int[] sortedArray = Arrays.copyOf(array, array.length);

    for (int j = 0; j < sortedArray.length; j++) {
      bubbleElement(sortedArray);
    }
    return sortedArray;
  }

  private void bubbleElement(int[] sortedArray) {
    for (int i = 0; i < sortedArray.length - 1; i++) {
      if (sortedArray[i] > sortedArray[i + 1]) {
        swap(sortedArray, i, i + 1);
      }
    }
  }
}
