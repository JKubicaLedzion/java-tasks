package pl.coderstrust.figures;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Figure {

  public double calculateArea();

  public void inputValidityCheck();

  public default double round(double value, int decimalPlaces) {
    BigDecimal bd = new BigDecimal(Double.toString(value));
    bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
}
