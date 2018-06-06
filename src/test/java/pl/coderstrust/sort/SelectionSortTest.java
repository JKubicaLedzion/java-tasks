package pl.coderstrust.sort;

public class SelectionSortTest extends SortingTestBase {

  @Override
  public SortingMethod getSortingMethod() {
    return new SelectionSort();
  }
}
