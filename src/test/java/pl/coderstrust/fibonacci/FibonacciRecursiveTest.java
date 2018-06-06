package pl.coderstrust.fibonacci;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class FibonacciRecursiveTest {

  FibonacciRecursive fibonacciRecursive;

  @Before
  public void setup() {
    fibonacciRecursive = new FibonacciRecursive();
  }

  @Test
  @Parameters({
    //  Given
    "0, 0",
    "2, 1",
    "7, 13",
    "16, 987"
  })
  public void fibonacciWhenPositiveNumberResultReturned(int fibonaciNumber, long expectedResult) {
    //  When
    long result = fibonacciRecursive.fibonacci(fibonaciNumber);
    //  Then
    Assert.assertEquals(expectedResult, result);
    Assert.assertThat(result, is(expectedResult));
  }

  @Test(expected = IllegalArgumentException.class)
  public void fibonacciWhenNegativeNumberExceptionThrown() {
    fibonacciRecursive.fibonacci(-1);
  }
}
