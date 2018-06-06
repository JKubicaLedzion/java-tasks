package pl.coderstrust.fileReader;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberProcessorUsingStreams {

  static final String REGEX = "\\s+";

  public String processLine(String line) {
    if (!line.matches("[0-9\\s]+")) {
      return null;
    }

    int sum =
        Arrays.stream(line.trim().split(REGEX)).mapToInt(number -> Integer.valueOf(number)).sum();

    String resultLine =
        Arrays.stream(line.trim().split(REGEX))
            .map(number -> number + " + ")
            .collect(Collectors.joining());

    return Arrays.stream(resultLine.split(REGEX))
        .limit(resultLine.split(REGEX).length - 1)
        .collect(Collectors.joining("", "", "=" + sum));
  }
}
