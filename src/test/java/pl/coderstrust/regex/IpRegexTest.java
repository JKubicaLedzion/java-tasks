package pl.coderstrust.regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class IpRegexTest {

  private static final int IP_MIN = 0;
  private static final int IP_MAX = 10;
  IpRegex ipRegex = new IpRegex();

  @Test
  @Parameters({"234.0.355.", "adb.255.255.100", "0123.111.0.0.", ""})
  public void isIpAddressWhenWrongInputShouldReturnFalse(String input) {
    boolean result = ipRegex.isIpAddress(input);
    Assert.assertThat(result, is(false));
  }

  //    @Ignore
  @Test
  public void isIpAddressWhenCorrectInputShouldReturnTrueForAllPossibilities() {
    for (int i = IP_MIN; i <= IP_MAX; i++) {
      for (int j = IP_MIN; j <= IP_MAX; j++) {
        for (int k = IP_MIN; k <= IP_MAX; k++) {
          for (int l = IP_MIN; l <= IP_MAX; l++) {
            boolean result = getResult(i, j, k, l);
            Assert.assertThat(result, is(true));
          }
        }
      }
    }
  }

  @Test
  public void isIpAddressShouldReturnTrueForAllPossibilitiesPart1stOfAddress() {
    for (int i = IP_MIN; i <= IP_MAX; i++) {
      boolean result = getResult(i, 1, 1, 1);
      Assert.assertThat(result, is(true));
    }
  }

  @Test
  public void isIpAddressShouldReturnTrueForAllPossibilitiesPart2ndOfAddress() {
    for (int i = IP_MIN; i <= IP_MAX; i++) {
      boolean result = getResult(1, i, 1, 1);
      Assert.assertThat(result, is(true));
    }
  }

  @Test
  public void isIpAddressShouldReturnTrueForAllPossibilitiesPart3rdOfAddress() {
    for (int i = IP_MIN; i <= IP_MAX; i++) {
      boolean result = getResult(1, 1, i, 1);
      Assert.assertThat(result, is(true));
    }
  }

  @Test
  public void isIpAddressShouldReturnTrueForAllPossibilitiesPart4thOfAddress() {
    for (int i = IP_MIN; i <= IP_MAX; i++) {
      boolean result = getResult(1, 1, 1, i);
      Assert.assertThat(result, is(true));
    }
  }

  private boolean getResult(int i, int j, int k, int l) {
    StringBuilder sb = new StringBuilder("");
    sb.append(
        Integer.toString(i)
            + "."
            + Integer.toString(j)
            + "."
            + Integer.toString(k)
            + "."
            + Integer.toString(l));
    return ipRegex.isIpAddress(sb.toString());
  }
}
