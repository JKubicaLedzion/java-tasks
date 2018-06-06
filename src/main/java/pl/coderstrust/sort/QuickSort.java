package pl.coderstrust.sort;

import java.util.Arrays;

public class QuickSort implements SortingMethod {

  @Override
  public int[] sort(int[] sourceArray) {
    int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
    quickSort(array, 0, array.length - 1);
    return array;
  }

  private void quickSort(int[] array, int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      int pivot = partition(array, startIndex, endIndex);
      quickSort(array, startIndex, pivot);
      quickSort(array, pivot + 1, endIndex);
    }
  }

  private int partition(int[] array, int startIndex, int endIndex) {
    int pivot = array[startIndex];
    int i = startIndex - 1;
    int j = endIndex + 1;

    while (true) {
      do {
        i++;
      } while (array[i] < pivot);
      do {
        j--;
      } while (array[j] > pivot);

      if (i >= j) {
        return j;
      }
      swap(array, i, j);
    }
  }
}
