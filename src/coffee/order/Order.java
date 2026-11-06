package coffee.order;

public class Order {
  private int number = 0;
  private String name = "";

  public Order( String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "  { Order number: " + number + ", Name: \"" + name + "\" }";
  }
}
