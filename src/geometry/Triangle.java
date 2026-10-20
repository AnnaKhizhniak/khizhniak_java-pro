package geometry;

public class Triangle implements Figure {
  private final double sideLength;
  private final double heightLength;

  public Triangle(double sideLength, double heightLength) {
    this.sideLength = sideLength;
    this.heightLength = heightLength;
  }

  @Override
  public double calcArea() {
    return (sideLength * heightLength) / 2;
  }
}
