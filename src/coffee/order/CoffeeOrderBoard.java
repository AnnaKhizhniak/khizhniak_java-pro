package coffee.order;

import java.util.LinkedHashMap;
import java.util.Map;

public class CoffeeOrderBoard {
  private int number = 0;
  private final Map<Integer, String> coffeeOrderBoard = new LinkedHashMap<>();

  public void add(Order order) {
    order.setNumber(++number);
    coffeeOrderBoard.put(order.getNumber(), order.getName());
  }

  public void print() {
    for(Integer key : coffeeOrderBoard.keySet()) {
      System.out.println("Order number: " + key + ", Name: " + coffeeOrderBoard.get(key));
    }
  }

  public void print(Map.Entry<Integer, String> board) {
    System.out.println("Order number: " + board.getKey() + ", Name: " + board.getValue());
  }

  public Map.Entry<Integer, String> deliver() {
    if (coffeeOrderBoard.isEmpty()) {
      System.out.println("The coffee order board is empty!");
      return null;
    }

    Map.Entry<Integer, String> firstOrder = coffeeOrderBoard.entrySet().iterator().next();
    Map.Entry<Integer, String> result = Map.entry(firstOrder.getKey(), firstOrder.getValue());
    coffeeOrderBoard.remove(firstOrder.getKey());

    return result;
  }

  public Map.Entry<Integer, String> deliver(int number) {
    if (!coffeeOrderBoard.containsKey(number)) {
      System.out.println("Order [" + number + "] not found!");
      return null;
    }

    Map.Entry<Integer, String> order = Map.entry(number, coffeeOrderBoard.get(number));
    coffeeOrderBoard.remove(number);
    return order;
  }

  public void draw() {
    System.out.println("================");
    System.out.println("Num | Name");
    for(Integer key : coffeeOrderBoard.keySet()) {
      System.out.println(key + "   | " + coffeeOrderBoard.get(key));
    }
  }

}
