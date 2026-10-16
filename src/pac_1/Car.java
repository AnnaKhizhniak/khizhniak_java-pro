package pac_1;

public class Car {
  public static void main(String[] args) {
    Car car = new Car();
    car.start();
  }

  public void start() {
    startElectricity();
    startCommand();
    startFuelSystem();
  }

  private void startFuelSystem() {
    System.out.println("Started fuel system");
  }

  private void startCommand() {
    System.out.println("Run started command");
  }

  private void startElectricity() {
    System.out.println("Started electricity");
  }
}
