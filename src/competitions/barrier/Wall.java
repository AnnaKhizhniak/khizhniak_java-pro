package competitions.barrier;

import competitions.participants.Participant;

public class Wall implements Barrier {
  private final double HEIGHT;

  public Wall(double height) {
    this.HEIGHT = height;
  }

  private String getName() {
    return "Wall";
  }

  @Override
  public boolean overcome(Participant participant) {
    if (HEIGHT > participant.jumpLimit()) {
      System.out.printf("Participant [%s] did not overcome the barrier [%s] with distance [%.2f] %n",
          participant.name(), this.getName(), (HEIGHT - participant.jumpLimit()));
      return false;
    }

    participant.jump();
    System.out.printf("Participant [%s]  overcome the barrier [%s] with height [%.2f] %n",
        participant.name(), this.getName(), HEIGHT);

      return true;

  }
}
