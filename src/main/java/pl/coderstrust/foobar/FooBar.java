package pl.coderstrust.foobar;

import java.util.HashMap;
import java.util.Map;

public class FooBar {

  public static void main(String[] args) {
    for (int i = 0; i <= 100; i++) {
      printFooBar(i);
    }

    int[] array = new int[101];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }

    for (int i : array) {
      printFooBar(i);
    }

    Map<Integer, String> map = new HashMap();

    for (int i = 0; i <= 100; i++) {
      if (i % 3 == 0) {
        if (i % 5 == 0) {
          map.put(i, "FooBar");
        } else {
          map.put(i, "Foo");
        }
      } else if (i % 5 == 0) {
        map.put(i, "Bar");
      } else {
        map.put(i, "");
      }
    }

    for (Integer key : map.keySet()) {
      System.out.println(key + " " + map.get(key));
    }
  }

  private static void printFooBarStringBuilder(int i) {
    StringBuilder sb = new StringBuilder(i);
    sb.append(" ");
    sb.append(i % 3 == 0 ? "Foo" : "");
    sb.append(i % 5 == 0 ? "Bar" : "");
    System.out.println(sb);
  }

  public static void printFooBar(int i) {
    System.out.println((i + " ") + (i % 3 == 0 ? "Foo" : "") + (i % 5 == 0 ? "Bar" : ""));
  }

  private static void printFooBarIf(int i) {
    System.out.print(i + " ");
    if (i % 3 == 0) {
      System.out.print("Foo");
    }
    if (i % 5 == 0) {
      System.out.print("Bar");
    }
    System.out.println();
  }
}
