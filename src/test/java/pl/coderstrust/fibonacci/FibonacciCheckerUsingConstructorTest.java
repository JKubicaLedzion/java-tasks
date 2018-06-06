package pl.coderstrust.fibonacci;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class FibonacciCheckerUsingConstructorTest {
  @Rule public ExpectedException exception = ExpectedException.none();
  private FibonacciCheckerUsingConstructor fibonacciChecker =
      new FibonacciCheckerUsingConstructor();

  @Test
  @FileParameters("src/test/resources/FibonacciCheckerParameters.csv")
  public void isFibonacciWhenPositiveNumberReturnTrueOrFalse(long number, boolean expectedResult) {
    //  When
    boolean result = fibonacciChecker.isFibonacciNumber(number);
    //  Then
    Assert.assertThat(result, is(expectedResult));
  }

  @Test
  public void isFibonacciWhenNegativeNumberExceptionThrown() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("Wrong number given. Only numbers >= 0 are valid.");
    fibonacciChecker.isFibonacciNumber(-12);
  }
}
