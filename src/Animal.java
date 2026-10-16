public abstract class Animal {
  private String name;
  private final int maxRunDistance;
  private final int maxSwimDistance;
  private static int count = 0;

  public Animal(String name, int maxRunDistance, int maxSwimDistance) {
    this.name = name;
    this.maxRunDistance = maxRunDistance;
    this.maxSwimDistance = maxSwimDistance;
    count++;
  }

  public Animal(String name, int maxRunDistance) {
    this(name, maxRunDistance, 0);
  }

  public static int getAnimalsCount() {
    return count;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void run(int distance) {
    if (distance <= 0) {
      System.out.println("Distance must be positive!");
      return;
    }

    if (maxRunDistance < distance) {
      System.out.println(getName() + " can't run more than " + maxRunDistance + " m!");
    } else {
      System.out.println(getName() + " run " + distance + " m");
    }
  }

  public void swim(int distance) {
    if (distance <= 0) {
      System.out.println("Distance must be positive!");
      return;
    }

    if (maxSwimDistance < distance) {
      System.out.println(getName() + " can't swim more than " + maxSwimDistance + " m!");
    } else {
      System.out.println(getName() + " swim " + distance + " m");
    }
  }

}
