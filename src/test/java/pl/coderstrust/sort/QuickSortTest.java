package pl.coderstrust.sort;

public class QuickSortTest extends SortingTestBase {

  @Override
  public SortingMethod getSortingMethod() {
    return new QuickSort();
  }
}
