package pl.coderstrust.fibonacci;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class FibonacciCheckerTest {

  @Rule public ExpectedException exception = ExpectedException.none();

  private FibonacciChecker fibonacciChecker = new FibonacciChecker();

  private static List<Long> generateAllFibonacciNumbersList() {
    List<Long> list =
        Stream.iterate(new long[] {0, 1}, s -> new long[] {s[1], s[0] + s[1]})
            .limit(93)
            .map(n -> n[0])
            .collect(Collectors.toList());
    return list;
  }

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
    // Then:
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("Wrong number given. Only numbers >= 0 are valid.");
    // When:
    fibonacciChecker.isFibonacciNumber(-12);
  }

  //    @Ignore
  @Test
  //    @Parameters(method = "generateAllFibonacciNumbers")
  @Parameters(method = "generateAllFibonacciNumbersList")
  public void isFibonacciShouldReturnTrueForAllFibonacciNumbers(long number) {
    //  When
    boolean result = fibonacciChecker.isFibonacciNumber(number);
    //  Then
    Assert.assertThat(result, is(true));
  }

  @Test
  public void isFibonacciShouldReturnTrueForAllFibonacciNumbersList() {
    List<Long> fibonacciList = generateAllFibonacciNumbersList();
    for (long number : fibonacciList) {
      boolean result = fibonacciChecker.isFibonacciNumber(number);
      Assert.assertThat(result, is(true));
    }
  }
}
