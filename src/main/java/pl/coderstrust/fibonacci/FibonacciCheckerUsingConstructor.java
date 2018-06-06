package pl.coderstrust.fibonacci;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciCheckerUsingConstructor {

  private Set<Long> fibonacciNumbers;

  public FibonacciCheckerUsingConstructor() {
    fibonacciNumbers =
        Stream.iterate(new long[] {0, 1}, s -> new long[] {s[1], s[0] + s[1]})
            .limit(93)
            .map(n -> n[0])
            .collect(Collectors.toSet());
  }

  public boolean isFibonacciNumber(long number) {
    validNumber(number);
    return fibonacciNumbers.contains(number);
  }

  private void validNumber(long number) {
    if (number < 0) {
      throw new IllegalArgumentException("Wrong number given. Only numbers >= 0 are valid.");
    }
  }
}
