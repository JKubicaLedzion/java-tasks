package pl.coderstrust.figures;

import java.util.InputMismatchException;

public class Triangle implements Figure {

  private double height;
  private double base;

  public Triangle(double height, double base) {
    this.height = height;
    this.base = base;
    inputValidityCheck();
  }

  @Override
  public double calculateArea() {
    double area = 0.5 * base * height;
    return round(area, 2);
  }

  @Override
  public void inputValidityCheck() {
    if (height < 0 || base < 0) {
      throw new InputMismatchException("Parameter should be equal or greater than 0.");
    }
  }
}
