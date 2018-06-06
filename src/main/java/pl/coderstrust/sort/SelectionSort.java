package pl.coderstrust.sort;

import java.util.Arrays;

public class SelectionSort implements SortingMethod {

  @Override
  public int[] sort(int[] array) {
    int[] sortedArray = Arrays.copyOf(array, array.length);

    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = getMinIndex(array, sortedArray, i);
      swap(sortedArray, i, minIndex);
    }
    return sortedArray;
  }

  private int getMinIndex(int[] array, int[] sortedArray, int i) {
    int minIndex = i;
    for (int j = i; j < array.length; j++) {
      if (sortedArray[j] < sortedArray[minIndex]) {
        minIndex = j;
      }
    }
    return minIndex;
  }
}
