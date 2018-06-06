package pl.coderstrust.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class TrapezoidTest {

  @Test(expected = InputMismatchException.class)
  public void calculateAreaWhenNegativeInputExceptionThrown() {
    Trapezoid trapezoid = new Trapezoid(-2, 7, 1);
  }

  @Test
  @Parameters({"1, 3, 1, 2", "0, 1, 3, 0", "0.6, 0.9, 0.3, 0.36", "4.27, 11.35, 5, 34.91"})
  public void calculateAreaWhenPositiveInputAreaReturned(
      double height, double base1, double base2, double expectedResult) {
    Trapezoid trapezoid = new Trapezoid(height, base1, base2);
    double result = trapezoid.calculateArea();
    Assert.assertThat(result, is(expectedResult));
  }
}
