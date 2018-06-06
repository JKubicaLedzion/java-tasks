package pl.coderstrust.fibonacci;

import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public class FibonacciChecker {

  long temp0;
  long temp1;
  private Set<Long> fibonacciSet;

  public FibonacciChecker() {
    this.fibonacciSet = new HashSet<>();
    temp0 = 0;
    temp1 = 1;
  }

  public boolean isFibonacciNumber(long number) {
    validNumber(number);

    if (isNotEmpty(fibonacciSet) && number < temp0) {
      return fibonacciSet.contains(number);
    }

    fibonacciSet = fillFibonacciNumbersSet(number, fibonacciSet);
    return fibonacciSet.contains(number);
  }

  private Set<Long> fillFibonacciNumbersSet(long number, Set<Long> fibonacciNumbers) {
    while (temp0 <= number) {
      if (!fibonacciNumbers.contains(temp0)) {
        fibonacciNumbers.add(temp0);
      }
      long sum = temp0 + temp1;
      temp0 = temp1;
      temp1 = sum;
    }
    return fibonacciNumbers;
  }

  private void validNumber(long number) {
    if (number < 0) {
      throw new IllegalArgumentException("Wrong number given. Only numbers >= 0 are valid.");
    }
  }
}
