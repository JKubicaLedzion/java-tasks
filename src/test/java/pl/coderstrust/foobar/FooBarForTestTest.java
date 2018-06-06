package pl.coderstrust.foobar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static pl.coderstrust.foobar.FooBarForTest.createStringArray;

@RunWith(JUnitParamsRunner.class)
public class FooBarForTestTest {

  @Test
  @Parameters(method = "parametersForShouldCreateFooBarArray")
  public void shouldCreateFooBarArray(int size, String[] expectedResult) {
    // When
    String[] result = createStringArray(size);
    // Then
    Assert.assertThat(result, is(result));
    Assert.assertThat(result, arrayWithSize(size));
  }

  private Object[] parametersForShouldCreateFooBarArray() {
    // Given
    return new Object[] {
      new Object[] {
        16,
        "0 FooBar",
        "1 ",
        "2 ",
        "3 Foo",
        "4 ",
        "5 Bar",
        "6 Foo",
        "7 ",
        "8 ",
        "9 Foo",
        "10 Bar",
        "11 ",
        "12 Foo",
        "13 ",
        "14 ",
        "15 FooBar"
      }
    };
  }
}
