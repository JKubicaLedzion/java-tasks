package pl.coderstrust.sort;

public class SortUsingCollectionsTest extends SortingTestBase {

  @Override
  public SortingMethod getSortingMethod() {
    return new SortUsingCollections();
  }
}
