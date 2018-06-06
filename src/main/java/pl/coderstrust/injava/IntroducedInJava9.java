package pl.coderstrust.injava;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntroducedInJava9 implements Printable {

  // Factory Methods for Immutable List, Set, Map and Map.Entry
  public Set<String> createImmutableSet() {
    return Set.of("injava", "b", "c", "d");
  }

  // Streams - improvements of some methods
  // 1. iterate​(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
  public List<Integer> generateIntegerList() {
    return Stream.iterate(0, i -> i <= 50, i -> i + 10).collect(Collectors.toList());
  }

  // 2. takeWhile​(Predicate<? super T> predicate)
  public List<String> createStringList() {
    return Stream.iterate("", s -> s + "*")
        .takeWhile(s -> s.length() <= 5)
        .collect(Collectors.toList());
  }
}
