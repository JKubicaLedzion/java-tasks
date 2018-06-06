package pl.coderstrust.sort;

public interface SortingMethod {

  int[] sort(int[] array);

  default void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
