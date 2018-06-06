package pl.coderstrust.search;

public class LinearSearch {

  public int search(int[] array, int element) {
    int indexOfSearchedElement = -1;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == element) {
        indexOfSearchedElement = i;
        break;
      }
    }
    return indexOfSearchedElement;
  }
}
