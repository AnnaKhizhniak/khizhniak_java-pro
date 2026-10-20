package geometry;

public class SquareCalculation {
  static void main(String[] args) {
    Figure[] figures = { new Circle(35), new Triangle(12, 34), new Square(10) };
    calcTotalArea(figures);
  }

  public static void calcTotalArea(Figure[] figures) {
    double result = 0;
    for (Figure f: figures) {
      result += f.calcArea();
    }
    System.out.printf("Total area: %.2f", result);
  }
}

interface Figure {
  double calcArea();
}
