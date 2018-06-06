package pl.coderstrust.fileReader;

public class NumberProcessor {

  public NumberProcessor() {}

  public String processLine(String line) {
    if (line.matches("[0-9\\s]+")) {
      return createResultLine(line);
    } else {
      return null;
    }
  }

  private String createResultLine(String line) {
    StringBuilder sb = new StringBuilder();
    String[] numbers = line.trim().split("\\s+");
    for (String s : numbers) {
      sb.append(s + " + ");
    }
    sb.replace(sb.length() - 2, sb.length() - 1, "=").append(calculateSum(numbers));
    return sb.toString();
  }

  private int calculateSum(String[] array) {
    int sum = 0;
    for (String s : array) {
      sum += Integer.parseInt(s);
    }
    return sum;
  }

  //  Alternative method to check if String contains only digits.
  private boolean containsOnlyDigits(String line) {
    for (int i = 0; i < line.length(); i++) {
      if (!Character.isDigit(line.charAt(i)) && line.charAt(i) != ' ') {
        return false;
      }
    }
    return true;
  }
}
