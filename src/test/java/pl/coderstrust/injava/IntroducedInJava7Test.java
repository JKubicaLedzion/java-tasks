package pl.coderstrust.injava;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class IntroducedInJava7Test {

  private IntroducedInJava7 java7 = new IntroducedInJava7();

  @Test
  public void readLinesShouldReadLineAndReturnString() {
    String result = java7.readLines("pl/coderstrust/injava/NewJava7v2.txt");
    Assert.assertThat(result, is("Delete"));
  }

  @Test
  public void selectActionShouldReadLineDisplayCorrectTextAndReturnZero() {
    String action = java7.readLines("pl/coderstrust/injava/NewJava7v0.txt");
    int result = java7.selectAction(action);
    Assert.assertThat(result, is(0));
  }

  @Test
  public void selectActionShouldReadLineDisplayCorrectTextAndReturnOne() {
    String action = java7.readLines("pl/coderstrust/injava/NewJava7v1.txt");
    int result = java7.selectAction(action);
    Assert.assertThat(result, is(1));
  }

  @Test
  public void selectActionShouldReadLineDisplayCorrectTextAndReturnTwo() {
    String action = java7.readLines("pl/coderstrust/injava/NewJava7v2.txt");
    int result = java7.selectAction(action);
    Assert.assertThat(result, is(2));
  }

  @Test
  public void selectActionShouldReadLineDisplayCorrectTextAndReturnTree() {
    String action = java7.readLines("pl/coderstrust/injava/NewJava7v3.txt");
    int result = java7.selectAction(action);
    Assert.assertThat(result, is(3));
  }
}
