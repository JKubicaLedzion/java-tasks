package pl.coderstrust.fibonacci;

public class FibonacciRecursive {

  public long fibonacci(int fibonaciNumber) {
    if (fibonaciNumber < 0) {
      throw new IllegalArgumentException(
          "Wrong input given, you cannot provide number lower than 0.");
    } else if (fibonaciNumber < 2) {
      return fibonaciNumber;
    }
    return fibonacci(fibonaciNumber - 1) + fibonacci(fibonaciNumber - 2);
  }
}
