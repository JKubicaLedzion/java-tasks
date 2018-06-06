package pl.coderstrust.fibonacci;

public class FibonacciIterative {

  public long fibonacci(int fibonacciNumber) {
    if (fibonacciNumber < 0) {
      throw new IllegalArgumentException("Wrong input given, you cannot provide number lower than 0.");
    }
    if (fibonacciNumber < 2) {
      return fibonacciNumber;
    }
    long temp0 = 0;
    long temp1 = 1;
    long temp2 = 0;
    for (int i = 2; i <= fibonacciNumber; i++) {
      temp2 = temp0 + temp1;
      temp0 = temp1;
      temp1 = temp2;
    }
    return temp2;
  }
}
