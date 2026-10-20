package competitions;

import competitions.barrier.*;
import competitions.participants.*;

public class Main {
  public static void main(String[] args) {
    Cat cat = new Cat("Kitty-Cat", 12, 1.5);
    Human human = new Human("John Doe", 60000, 0.5);
    Robot robot = new Robot("Robot v.2", 234.8, 8.9);
    Participant[] participants = { cat, human, robot};

    RunningTrack runningTrack = new RunningTrack(50.4);
    Wall wall = new Wall(2.45);
    Barrier[] barriers = { runningTrack, wall };

    overcomeBarriers(participants, barriers);
  }

  public static void overcomeBarriers(Participant[] participants, Barrier[] barriers) {
    for (int i = 0; i < participants.length; i++) {
      for (int j = 0; j < barriers.length; j++) {
        boolean canOvercome = barriers[j].overcome(participants[i]);
        if (!canOvercome) {
          break;
        }
      }
    }
  }
}
