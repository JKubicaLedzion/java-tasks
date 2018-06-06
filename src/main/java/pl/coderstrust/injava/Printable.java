package pl.coderstrust.injava;

import java.util.List;

public interface Printable {

  // Private interface methods
  private void startPrinting() {
    System.out.println("Printing starts:");
  }

  default void printingStringList(List<String> list) {
    startPrinting();
    list.forEach(System.out::println);
  }

  default void printingIntegerList(List<Integer> list) {
    startPrinting();
    list.forEach(System.out::println);
  }
}
