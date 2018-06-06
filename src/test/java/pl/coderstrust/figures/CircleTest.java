package pl.coderstrust.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class CircleTest {

  @Test(expected = InputMismatchException.class)
  public void calculateAreaWhenNegativeInputExceptionThrown() {
    Circle circle = new Circle(-1);
  }

  @Test
  @Parameters({"1, 3.14", "0, 0", "14, 615.75", "2.4, 18.10"})
  public void calculateAreaWhenPositiveInputAreaReturned(double radius, double expectedResult) {
    Circle circle = new Circle(radius);
    double result = circle.calculateArea();
    Assert.assertThat(result, is(expectedResult));
  }
}
