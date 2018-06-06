package pl.coderstrust.christmas;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChristmasTreeStream {

  public static String[] createChristmasTreeStream(int size) {
    String[] christmasTree =
        IntStream.range(0, size)
            .mapToObj(i -> new String(printSpacesStream(size, i) + printStarsStream(i)))
            .toArray(s -> new String[s]);
    christmasTree[size - 1] = size > 2 ? (printSpacesStream(size, 1) + "**") : "";
    return christmasTree;
  }

  private static String printSpacesStream(int size, int number) {
    return IntStream.range(number, size)
        .mapToObj(i -> new String(" "))
        .collect(Collectors.joining());
  }

  private static String printStarsStream(int number) {
    return "*"
        + IntStream.range(0, number).mapToObj(i -> new String("**")).collect(Collectors.joining());
  }
}
