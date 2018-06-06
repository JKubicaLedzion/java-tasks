package pl.coderstrust.regex;

public class IpRegex {

  private static final String IP_0_255 = "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
  private static final String IP_REGEX =
      IP_0_255 + "\\." + IP_0_255 + "\\." + IP_0_255 + "\\." + IP_0_255;

  public boolean isIpAddress(String input) {
    return input.matches(IP_REGEX);
  }
}
