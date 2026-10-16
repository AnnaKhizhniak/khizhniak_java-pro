public class Cat extends Animal {
  private static final int RUN_DISTANCE = 200;
  private static int count = 0;

  public Cat(String name) {
    super(name, RUN_DISTANCE);
    count++;
  }

  public static int getCatsCount() {
    return count;
  }

  @Override
  public void swim(int distance) {
    System.out.println(getName() + " can't swim!");
  }
}
