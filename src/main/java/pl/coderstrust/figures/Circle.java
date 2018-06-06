package pl.coderstrust.figures;

import java.util.InputMismatchException;

public class Circle implements Figure {

  private double radius;

  public Circle(double radius) {
    this.radius = radius;
    inputValidityCheck();
  }

  @Override
  public double calculateArea() {
    double area = Math.PI * Math.pow(radius, 2);
    return round(area, 2);
  }

  @Override
  public void inputValidityCheck() {
    if (radius < 0) {
      throw new InputMismatchException("Parameter should be equal or greater than 0.");
    }
  }
}
