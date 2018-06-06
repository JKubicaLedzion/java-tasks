package pl.coderstrust.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class RectangleTest {

  @Test(expected = InputMismatchException.class)
  public void calculateAreaWhenNegativeInputExceptionThrown() {
    Rectangle rectangle = new Rectangle(-1, 7);
  }

  @Test
  @Parameters({"1, 3, 3", "0, 1, 0", "0.6, 0.9, 0.54", "4.27, 11.35, 48.46"})
  public void calculateAreaWhenPositiveInputAreaReturned(
      double side1, double side2, double expectedResult) {
    Rectangle rectangle = new Rectangle(side1, side2);
    double result = rectangle.calculateArea();
    Assert.assertThat(result, is(expectedResult));
  }
}
