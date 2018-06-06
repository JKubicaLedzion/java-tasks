package pl.coderstrust.figures;

import java.util.InputMismatchException;

public class Rectangle implements Figure {

  private double side1;
  private double side2;

  public Rectangle(double side1, double side2) {
    this.side1 = side1;
    this.side2 = side2;
    inputValidityCheck();
  }

  @Override
  public double calculateArea() {
    double area = side1 * side2;
    return round(area, 2);
  }

  @Override
  public void inputValidityCheck() {
    if (side1 < 0 || side2 < 0) {
      throw new InputMismatchException("Parameter should be equal or greater than 0.");
    }
  }
}
