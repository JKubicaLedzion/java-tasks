package pl.coderstrust.search;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class LinearTest {

  LinearSearch search = new LinearSearch();

  private static int[] createArray() {
    Random random = new Random();
    return random.ints(50000000).toArray();
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
      new Object[] {new int[] {3, 6, -2, -8, 7, 90, 54}, -2, 2},
      new Object[] {new int[] {5, 5, 5, 5}, 5, 0},
      new Object[] {new int[] {-345, 456, 234, 99, -567}, -567, 4},
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
      new Object[] {new int[] {3, 6, -2, -8, 7, 90, 54}, 5},
      new Object[] {new int[] {5, 5, 5, 5}, 1},
      new Object[] {new int[] {}, 2}
    };
  }

  @Test
  public void searchShouldReturnedIndexOfSearchedElementOnRandomArray() {
    int[] source = createArray();
    int element = source[49999999];
    int expectedResult = ArrayUtils.indexOf(source, element);

    long startTime = System.currentTimeMillis();

    int result = search.search(source, element);

    long endTime = System.currentTimeMillis();
    System.out.println("Time: " + (endTime - startTime));

    Assert.assertThat(result, is(expectedResult));
  }
}
