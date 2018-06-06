package pl.coderstrust.christmas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static pl.coderstrust.christmas.ChristmasTreeForTest.createChristmasTree;

@RunWith(JUnitParamsRunner.class)
public class ChristmasTreeForTestTest {

  @Test
  @Parameters(method = "parametersForShouldReturnChristmasTreeFromStars")
  public void shouldReturnChristmasTreeFromStars(int size, String[] expectedResult) {
    // When
    String[] result = createChristmasTree(size);
    // Then
    Assert.assertThat(result, is(result));
    Assert.assertThat(result, arrayWithSize(size));
  }

  private Object[] parametersForShouldReturnChristmasTreeFromStars() {
    // Given
    return new Object[] {
      new Object[] {4, "    *", "   ***", "  *****", "   **"},
      new Object[] {6, "      *", "     ***", "    *****", "   *******", "  *********", "     **"},
      new Object[] {
        10,
        "          *",
        "         ***",
        "        *****",
        "       *******",
        "      *********",
        "     ***********",
        "    *************",
        "   ***************",
        "  *****************",
        " *******************",
        "*********************",
        "         **",
      }
    };
  }
}
