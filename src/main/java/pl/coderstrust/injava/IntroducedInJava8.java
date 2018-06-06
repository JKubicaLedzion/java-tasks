package pl.coderstrust.injava;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntroducedInJava8 {

  // Streams
  public List<Integer> generateIntegerList(int n) {
    return Stream.iterate(0, i -> i + 1).limit(n).collect(Collectors.toList());
  }

  // Predicate + method references + Optional + Lambda + Supplier
  public int sumOfProcessedListElements(List<Integer> list) {
    Calculable calculable = i -> i + 5;
    Supplier supplier = () -> Integer.valueOf(-1);
    return list.stream()
        .filter(i -> i % 2 == 0)
        .map(this::multiply)
        .map(calculable::calculate)
        .reduce((i, j) -> i + j)
        .orElseGet(supplier);
  }

  private Integer multiply(Integer n) {
    return n * n;
  }
}
