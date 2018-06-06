package pl.coderstrust.injava;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;

public class IntroducedInJava9Test {

  IntroducedInJava9 newJava9 = new IntroducedInJava9();

  @Test
  public void createImmutableSetShouldReturnSet() {
    Set<String> expectedResult = Sets.newSet("injava", "b", "c", "d");
    Set<String> result = newJava9.createImmutableSet();
    Assert.assertThat(result, is(expectedResult));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void createImmutableSetWhileAddingElementsShouldExceptionThrown() {
    Set<String> set = newJava9.createImmutableSet();
    set.add("e");
  }

  @Test
  public void createStringListShouldReturnStringList() {
    List<String> expectedResult = Arrays.asList("", "*", "**", "***", "****", "*****");
    List<String> result = newJava9.createStringList();
    Assert.assertThat(result, is(expectedResult));
  }

  @Test
  public void generateIntegerList() {
    List<Integer> expectedResult = Arrays.asList(0, 10, 20, 30, 40, 50);
    List<Integer> result = newJava9.generateIntegerList();
    Assert.assertThat(result, is(expectedResult));
  }

  @Test
  public void printingStringList() {
    newJava9.printingStringList(newJava9.createStringList());
  }

  @Test
  public void printingIntegerList() {
    newJava9.printingIntegerList(newJava9.generateIntegerList());
  }
}
