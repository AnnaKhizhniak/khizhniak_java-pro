package competitions.barrier;

import competitions.participants.Participant;

public class RunningTrack implements Barrier {
  private final double LENGTH;

  public RunningTrack(double length) {
    this.LENGTH = length;
  }

  private String getName() {
    return "Running truck";
  }

  @Override
  public boolean overcome(Participant participant) {
    if (LENGTH > participant.runLimit()) {
      System.out.printf("Participant [%s] did not overcome the barrier [%s] with distance [%.2f] %n",
          participant.name(), this.getName(), (LENGTH - participant.runLimit()));
      return false;
    }

    participant.run();
    System.out.printf("Participant [%s]  overcome the barrier [%s] with distance [%.2f] %n",
        participant.name(), this.getName(), LENGTH);
    return true;
  }
}
