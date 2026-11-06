package coffee.order;

import java.util.Map;

public class Main {
  static void main(String[] args) {
    CoffeeOrderBoard board = new CoffeeOrderBoard();

    board.add(new Order("Anna"));
    board.add(new Order( "Oleg"));
    board.add(new Order( "Inna"));
    board.add(new Order( "Joe"));
    board.add(new Order( "Dima"));
    board.add(new Order( "Kristina"));
    board.add(new Order( "John"));
    board.print();

    Map.Entry<Integer, String> firstDeliveredOrder = board.deliver();
    if (firstDeliveredOrder != null) {
      System.out.println("Deliver first order:");
      board.print(firstDeliveredOrder);
    }

    Map.Entry<Integer, String> deliveredOrder = board.deliver(7);
    if (deliveredOrder != null) {
      System.out.println("Deliver specific order:");
      board.print(deliveredOrder);
    }

    board.draw();
  }
}
