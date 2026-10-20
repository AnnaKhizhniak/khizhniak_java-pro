package competitions.participants;

public interface Participant {
  double runLimit();
  double jumpLimit();
  String name();

  default void run() {
    System.out.println("Participant running");
  }
  default void jump() {
    System.out.println("Participant jumping");
  }
}
