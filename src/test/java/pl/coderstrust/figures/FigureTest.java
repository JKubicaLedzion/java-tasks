package pl.coderstrust.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class FigureTest {

  @Test
  @Parameters(method = "parametersForCalculateArea")
  public void calculateAreaWhenPositiveInputAreaReturned(Figure figure, double expectedResult) {
    double result = figure.calculateArea();
    Assert.assertThat(result, is(expectedResult));
  }

  private Object[] parametersForCalculateArea() {
    return new Object[] {
      new Object[] {new Circle(2.4), 18.10},
      new Object[] {new Square(4), 16},
      new Object[] {new Rectangle(0.6, 0.9), 0.54},
      new Object[] {new Triangle(4.27, 11.35), 24.23},
      new Object[] {new Trapezoid(0.6, 0.9, 0.3), 0.36},
    };
  }
}
