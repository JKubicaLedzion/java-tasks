package pl.coderstrust.search;

import org.apache.commons.lang3.ArrayUtils;

import java.util.InputMismatchException;

public class BinarySearch {

  public int search(int[] array, int element) {
    if (isNotSorted(array)) {
      throw new InputMismatchException("Provided array should be sorted.");
    }

    int leftIndex = 0;
    int rightIndex = array.length - 1;
    return partitionArray(leftIndex, rightIndex, array, element, -1);
  }

  private int partitionArray(int leftIndex, int rightIndex, int[] array, int element, int index) {
    if (leftIndex == rightIndex && array[leftIndex] == element) {
      index = leftIndex;
      return index;
    }

    while (leftIndex < rightIndex) {
      int middleIndex = (leftIndex + rightIndex) / 2;
      if (array[middleIndex] == element) {
        return middleIndex;
      }
      if (array[middleIndex] < element) {
        leftIndex = middleIndex + 1;
        index = partitionArray(leftIndex, rightIndex, array, element, index);
      }
      if (array[middleIndex] > element) {
        rightIndex = middleIndex - 1;
        index = partitionArray(leftIndex, rightIndex, array, element, index);
      }
    }
    return index;
  }

  private boolean isNotSorted(int[] array) {
    return !ArrayUtils.isSorted(array);
  }
}
