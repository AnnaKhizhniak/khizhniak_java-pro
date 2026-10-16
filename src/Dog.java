public class Dog extends Animal{
  private static final int RUN_DISTANCE = 500;
  private static final int SWIM_DISTANCE = 10;
  private static int count = 0;

  public Dog(String name) {
    super(name, RUN_DISTANCE, SWIM_DISTANCE);
    count++;
  }

  public static int getDogsCount() {
    return count;
  }
}
