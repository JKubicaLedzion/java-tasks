package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {

  public int[] sieve(int maximumNumber) {

    boolean[] isPrime = getBooleanArray(maximumNumber);

    markNonPrimeNumbers(isPrime);

    return getPrimeNumbersArray(isPrime);
  }

  private void markNonPrimeNumbers(boolean[] isPrime) {
    int maximumNumber = isPrime.length - 1;
    for (int i = 2; i < Math.sqrt(maximumNumber); i++) {
      if (isPrime[i]) {
        for (int j = i * 2; j <= maximumNumber; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }

  private boolean[] getBooleanArray(int maximumNumber) {
    boolean[] isPrime = new boolean[maximumNumber + 1];
    Arrays.fill(isPrime, 2, maximumNumber + 1, true);
    return isPrime;
  }

  private int[] getPrimeNumbersArray(boolean[] isPrime) {
    int primeNumbersCount = getPrimeNumbersCount(isPrime);
    int[] primeNumbersArray = new int[primeNumbersCount];

    int index = 0;
    for (int i = 0; i < isPrime.length; i++) {
      if (isPrime[i]) {
        primeNumbersArray[index] = i;
        index++;
      }
    }
    return primeNumbersArray;
  }

  private int getPrimeNumbersCount(boolean[] isPrime) {
    int primeNumbersCount = 0;
    for (int i = 0; i < isPrime.length; i++) {
      if (isPrime[i]) {
        primeNumbersCount++;
      }
    }
    return primeNumbersCount;
  }
}
