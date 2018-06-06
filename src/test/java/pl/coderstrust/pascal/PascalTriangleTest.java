package pl.coderstrust.pascal;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class PascalTriangleTest {

  private PascalTriangle pascalTriangle = new PascalTriangle();

  @Test
  @Parameters
  public void shouldCreatePascalTriangleArray(int size, String[] expectedResult) {
    // When
    String[] result = pascalTriangle.createPascalTriangle(size);
    // Then
    Assert.assertThat(result, is(expectedResult));
  }

  // Given
  private Object[] parametersForShouldCreatePascalTriangleArray() {
    return new Object[] {
      new Object[] {5, "    1 ", "   1 1 ", "  1 2 1 ", " 1 3 3 1 ", "1 4 6 4 1 "}
    };
  }
}
