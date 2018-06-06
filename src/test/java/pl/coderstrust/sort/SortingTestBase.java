package pl.coderstrust.sort;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public abstract class SortingTestBase {

  private static int[] createArray() {
    Random random = new Random();
    return random.ints(1000).toArray();
  }

  public abstract SortingMethod getSortingMethod();

  @Test
  @Parameters(method = "parametersForShouldNotChangeSourceArray")
  public void shouldNotChangeSourceArray(int[] source) {
    // when
    int[] copyOfSourceArray = Arrays.copyOf(source, source.length);
    getSortingMethod().sort(source);
    // then
    Assert.assertThat(source, is(copyOfSourceArray));
  }

  @Test
  @Parameters(method = "parametersForShouldSortSimpleArray")
  public void shouldSortSimpleArray(int[] source, int[] expectedResult) {
    // when
    long startTime = System.currentTimeMillis();

    int[] result = getSortingMethod().sort(source);

    long endTime = System.currentTimeMillis();
    System.out.println("Time: " + (endTime - startTime));

    // then
    Assert.assertThat(result, is(expectedResult));
  }

  private Object[] parametersForShouldNotChangeSourceArray() {
    return new Object[] {
      new Object[] {createArray()},
      new Object[] {new int[] {}},
      new Object[] {new int[] {-1, 0, -16, 789, -2, 8, 0}},
      new Object[] {new int[] {-5, -4, 0, 2, 5, 99, 123}},
      new Object[] {new int[] {176}},
      new Object[] {new int[] {145, 101, 87, 9, 4, -1, -12}},
    };
  }

  private Object[] parametersForShouldSortSimpleArray() {
    // given
    int[] randomArray = createArray();
    int[] sortedRandomArray = Arrays.copyOf(randomArray, randomArray.length);
    Arrays.sort(sortedRandomArray);

    return new Object[] {
      new Object[] {randomArray, sortedRandomArray},
      new Object[] {new int[] {}, new int[] {}},
      new Object[] {new int[] {-1, 0, -16, 789, -2, 8, 0}, new int[] {-16, -2, -1, 0, 0, 8, 789}},
      new Object[] {new int[] {-5, -4, 0, 2, 5, 99, 123}, new int[] {-5, -4, 0, 2, 5, 99, 123}},
      new Object[] {new int[] {176}, new int[] {176}},
      new Object[] {
        new int[] {145, 101, 87, 9, 4, -1, -12}, new int[] {-12, -1, 4, 9, 87, 101, 145}
      },
      new Object[] {new int[] {5, 5, 5, 5, 5}, new int[] {5, 5, 5, 5, 5}},
    };
  }
}
