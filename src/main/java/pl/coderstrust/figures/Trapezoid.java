package pl.coderstrust.figures;

import java.util.InputMismatchException;

public class Trapezoid implements Figure {

  private double height;
  private double base1;
  private double base2;

  public Trapezoid(double height, double base1, double base2) {
    this.height = height;
    this.base1 = base1;
    this.base2 = base2;
    inputValidityCheck();
  }

  @Override
  public double calculateArea() {
    double area = height * ((base1 + base2) / 2);
    return round(area, 2);
  }

  @Override
  public void inputValidityCheck() {
    if (height < 0 || base1 < 0 || base2 < 0) {
      throw new InputMismatchException("Parameter should be equal or greater than 0.");
    }
  }
}
