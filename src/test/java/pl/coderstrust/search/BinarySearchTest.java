package pl.coderstrust.search;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class BinarySearchTest {

  BinarySearch search = new BinarySearch();

  private static int[] createSortedArray() {
    Random random = new Random();
    int[] sourceArray = IntStream.of(random.ints(50000000).toArray()).sorted().toArray();
    return sourceArray;
  }

  @Test
  @Parameters(method = "parametersForSearchShouldReturnedIndexOfSearchedElement")
  public void searchShouldReturnedIndexOfSearchedElement(
      int[] source, int element, int expectedResult) {
    int result = search.search(source, element);
    Assert.assertThat(result, is(expectedResult));
  }

  private Object[] parametersForSearchShouldReturnedIndexOfSearchedElement() {
    return new Object[] {
      new Object[] {new int[] {-8, -2, 3, 6, 7, 54, 90}, -2, 1},
      new Object[] {new int[] {5, 5, 5, 5}, 5, 1},
      new Object[] {new int[] {-567, -345, 99, 234, 456}, -567, 0},
      new Object[] {
        new int[] {-1938264687, -1447328992, 275693650, 632708605, 1890154368}, 1890154368, 4
      }
    };
  }

  @Test
  @Parameters(method = "parametersForSearchShouldReturnedNegativeIndexWhenElementNotFound")
  public void searchShouldReturnedNegativeIndexWhenElementNotFound(int[] source, int element) {
    int result = search.search(source, element);
    Assert.assertThat(result, is(-1));
  }

  private Object[] parametersForSearchShouldReturnedNegativeIndexWhenElementNotFound() {
    return new Object[] {
      new Object[] {new int[] {-8, -2, 3, 6, 7, 90, 90}, 5},
      new Object[] {new int[] {5, 5, 5, 5}, 1},
      new Object[] {new int[] {}, 2}
    };
  }

  @Test
  public void searchShouldReturnedIndexOfSearchedElementOnRandomArray() {
    int[] source = createSortedArray();

    int element = source[49999999];
    int expectedResult = ArrayUtils.indexOf(source, element);

    long startTime = System.currentTimeMillis();

    int result = search.search(source, element);

    long endTime = System.currentTimeMillis();
    System.out.println("Time: " + (endTime - startTime));

    Assert.assertThat(result, is(expectedResult));
  }

  @Test(expected = InputMismatchException.class)
  @Parameters(method = "parametersForSearchWhenNotSortedArrayExceptionThrown")
  public void searchWhenNotSortedArrayExceptionThrown(int[] source) {
    search.search(source, 3);
  }

  private Object[] parametersForSearchWhenNotSortedArrayExceptionThrown() {
    return new Object[] {
      new Object[] {new int[] {3, 6, -2, -8, 7, 90, 54}},
      new Object[] {new int[] {5, 4, 3, 2}},
    };
  }
}
