package pl.coderstrust.multiplication;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static pl.coderstrust.multiplication.MultiplicationTableStream.*;

@RunWith(JUnitParamsRunner.class)
public class MultiplicationTableStreamTest {

  @Test
  @Parameters(method = "parametersForShouldReturnMultiplicationTableWithStrings")
  public void shouldReturnMultiplicationTableWithStrings(int size, String[][] expectedResult) {
    // When
    int[][] intTable = createArray(size);
    String[][] result = createStringTable(intTable);
    // Then
    Assert.assertThat(result, is(expectedResult));
  }

  @Test
  @Parameters(method = "parametersForShouldReturnMultiplicationTableWithInts")
  public void shouldReturnMultiplicationTableWithInts(int size, int[][] expectedResult) {
    // When
    int[][] result = createArray(size);
    // Then
    Assert.assertThat(result, is(expectedResult));
  }

  private Object[] parametersForShouldReturnMultiplicationTableWithInts() {
    // Given
    return new Object[] {
      new Object[] {
        1,
        new int[][] {
          {0, 1},
          {1, 1}
        }
      },
      new Object[] {
        4,
        new int[][] {
          {0, 1, 2, 3, 4},
          {1, 1, 2, 3, 4},
          {2, 2, 4, 6, 8},
          {3, 3, 6, 9, 12},
          {4, 4, 8, 12, 16}
        }
      },
      new Object[] {
        7,
        new int[][] {
          {0, 1, 2, 3, 4, 5, 6, 7},
          {1, 1, 2, 3, 4, 5, 6, 7},
          {2, 2, 4, 6, 8, 10, 12, 14},
          {3, 3, 6, 9, 12, 15, 18, 21},
          {4, 4, 8, 12, 16, 20, 24, 28},
          {5, 5, 10, 15, 20, 25, 30, 35},
          {6, 6, 12, 18, 24, 30, 36, 42},
          {7, 7, 14, 21, 28, 35, 42, 49}
        }
      },
    };
  }

  private Object[] parametersForShouldReturnMultiplicationTableWithStrings() {
    // Given
    return new Object[] {
      new Object[] {
        2,
        new String[][] {
          {"  ", " 1", " 2"},
          {" 1", " 1", " 2"},
          {" 2", " 2", " 4"}
        }
      },
      new Object[] {
        4,
        new String[][] {
          {"   ", "  1", "  2", "  3", "  4"},
          {"  1", "  1", "  2", "  3", "  4"},
          {"  2", "  2", "  4", "  6", "  8"},
          {"  3", "  3", "  6", "  9", " 12"},
          {"  4", "  4", "  8", " 12", " 16"}
        }
      }
    };
  }
}
