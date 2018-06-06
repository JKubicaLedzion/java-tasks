package pl.coderstrust.foobar;

public class FooBarForTest {

  public static void main(String[] args) {

    String[] fooBarArray = createStringArray(10);
    for (int i = 0; i < fooBarArray.length; i++) {
      System.out.println(fooBarArray[i]);
    }
  }

  public static String[] createStringArray(int size) {
    String[] stringArray = new String[size];
    for (int i = 0; i < stringArray.length; i++) {
      stringArray[i] = (i + " ") + (i % 3 == 0 ? "Foo" : "") + (i % 5 == 0 ? "Bar" : "");
    }
    return stringArray;
  }
}
