package pl.coderstrust.sort;

import java.util.Objects;

public class HoarePartition {

  public int[] partition(int[] array) {
    if (Objects.isNull(array) || array.length <= 1) {
      return array;
    }

    int pivotIndex = (array.length - 1) / 2;
    int pivot = array[pivotIndex];
    swap(array, 0, pivotIndex);

    int i = 1;
    int j = array.length - 1;

    while (i < j) {
      while (array[i] <= pivot && i < j) {
        i++;
      }
      while (array[j] >= pivot && j > i) {
        j--;
      }

      swap(array, i, j);
      i++;
      j--;
    }

    int lowestNumberIndex = 1;
    while (lowestNumberIndex < (array.length - 1) && array[lowestNumberIndex + 1] < pivot) {
      lowestNumberIndex++;
    }

    swap(array, 0, lowestNumberIndex);
    return array;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
