package pl.coderstrust.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class SquareTest {

  @Test(expected = InputMismatchException.class)
  public void calculateAreaWhenNegativeInputExceptionThrown() {
    Square square = new Square(-1);
  }

  @Test
  @Parameters({"1, 1", "0, 0", "0.6, 0.36", "4.27, 18.23"})
  public void calculateAreaWhenPositiveInputAreaReturned(double side, double expectedResult) {
    Square square = new Square(side);
    double result = square.calculateArea();
    Assert.assertThat(result, is(expectedResult));
  }
}
