package pl.coderstrust.foobar;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FooBarForStream {

  public static void main(String[] args) {

    String[] fooBarArray = createStringArray(100);
    Arrays.stream(fooBarArray).forEach(System.out::println);
  }

  public static String[] createStringArray(int size) {
    return IntStream.range(0, size)
        .mapToObj(
            s -> new String((s + " ") + (s % 3 == 0 ? "Foo" : "") + (s % 5 == 0 ? "Bar" : "")))
        .toArray(s -> new String[s]);
  }
}
