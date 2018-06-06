package pl.coderstrust.sieve;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class SieveOfEratosthenesTest {

  private SieveOfEratosthenes sieve = new SieveOfEratosthenes();

  @Test
  @Parameters(method = "parametersForShouldReturnPrimeNumbersArray")
  public void shouldReturnPrimeNumbersArray(int maximumNumber, int[] expectedResult) {
    // when
    int[] result = sieve.sieve(maximumNumber);
    // then
    Assert.assertThat(result, is(expectedResult));
  }

  private Object[] parametersForShouldReturnPrimeNumbersArray() {
    // given
    return new Object[] {
      new Object[] {2, new int[] {2}},
      new Object[] {30, new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}},
      new Object[] {10, new int[] {2, 3, 5, 7}},
      new Object[] {6, new int[] {2, 3, 5}},
      new Object[] {
        100,
        new int[] {
          2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
          89, 97
        }
      }
    };
  }
}
