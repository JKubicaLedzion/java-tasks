package pl.coderstrust.fileReader;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NumberProcessorUsingStreamsTest {

  private NumberProcessorUsingStreams numberProcessor = new NumberProcessorUsingStreams();

  @Test
  @Parameters(method = "parametersForProcessLineWhenLineMatchWithRegexResultReturned")
  public void processLineWhenLineMatchWithRegexResultReturned(
      String source, String expectedResult) {
    String result = numberProcessor.processLine(source);
    assertThat(result, is(expectedResult));
  }

  private Object[] parametersForProcessLineWhenLineMatchWithRegexResultReturned() {
    return new Object[] {
      new Object[] {"4567892", "4567892=4567892"},
      new Object[] {"2345 4561 34199", "2345+4561+34199=41105"},
      new Object[] {" 11    125             ", "11+125=136"},
      new Object[] {"1  7  6  14", "1+7+6+14=28"}
    };
  }

  @Test
  @Parameters(method = "parametersForProcessLineWhenLineNotMatchedWithRegexShouldReturnNull")
  public void processLineWhenLineNotMatchWithRegexShouldReturnNull(String source) {
    String result = numberProcessor.processLine(source);
    assertNull(result);
  }

  private Object[] parametersForProcessLineWhenLineNotMatchedWithRegexShouldReturnNull() {
    return new Object[] {
      new Object[] {"q t g 7 s g "},
      new Object[] {""},
      new Object[] {" 1 4 5 8 90 ."},
      new Object[] {"1 + 7 + 6 = 14"}
    };
  }
}
