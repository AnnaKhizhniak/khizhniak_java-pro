package geometry;

public class Square implements Figure {
  private final double sideLength;

  public Square(double sideLength) {
    this.sideLength = sideLength;
  }

  @Override
  public double calcArea() {
    return Math.pow(sideLength, 2);
  }
}
