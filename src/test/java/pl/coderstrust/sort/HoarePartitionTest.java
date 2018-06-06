package pl.coderstrust.sort;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class HoarePartitionTest {

  private HoarePartition hoarePartition = new HoarePartition();

  @Test
  @Parameters(method = "parametersForShouldReturnDividedArray")
  public void shouldReturnDividedArray(int[] source, int[] expectedResult) {
    int[] result = hoarePartition.partition(source);
    Assert.assertThat(result, is(expectedResult));
  }

  private Object[] parametersForShouldReturnDividedArray() {
    return new Object[] {
      new Object[] {new int[] {}, new int[] {}},
      new Object[] {new int[] {-1, 0, -16, 789, -2, 8, 0}, new int[] {0, 0, -16, -1, -2, 8, 789}},
      new Object[] {new int[] {-5, -4, 0, 2, 5, 99, 123}, new int[] {-5, -4, 0, 2, 5, 99, 123}},
      new Object[] {new int[] {176}, new int[] {176}},
      new Object[] {
        new int[] {145, 101, 87, 9, 4, -1, -12}, new int[] {4, -12, -1, 9, 145, 87, 101}
      },
      new Object[] {new int[] {5, 5, 5, 5, 5}, new int[] {5, 5, 5, 5, 5}},
    };
  }
}
