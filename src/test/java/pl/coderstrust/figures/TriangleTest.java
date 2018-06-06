package pl.coderstrust.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class TriangleTest {

  @Test(expected = InputMismatchException.class)
  public void calculateAreaWhenNegativeInputExceptionThrown() {
    Triangle triangle = new Triangle(-1, 7);
  }

  @Test
  @Parameters({"1, 3, 1.5", "0, 1, 0", "0.6, 0.9, 0.27", "4.27, 11.35, 24.23"})
  public void calculateAreaWhenPositiveInputAreaReturned(
      double base, double height, double expectedResult) {
    Triangle triangle = new Triangle(base, height);
    double result = triangle.calculateArea();
    Assert.assertThat(result, is(expectedResult));
  }
}
