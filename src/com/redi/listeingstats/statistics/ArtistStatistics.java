package com.redi.listeingstats.statistics;

import com.redi.listeingstats.User;
import java.util.HashMap;
import java.util.Map;

public class ArtistStatistics {
  Map<User, Integer> trackPlays = new HashMap<>();

  public void recordPlay(final User user) {
    int totalPlays = this.trackPlays.getOrDefault(user, 0) + 1;
    this.trackPlays.put(user, totalPlays);
  }

  public User getTopFan() {
    int currentMax = 0;
    User topFan = null;
    for(User t : trackPlays.keySet()) {
      int trackNumber = trackPlays.get(t);
      if (trackNumber > currentMax) {
        currentMax = trackNumber;
        topFan = t;
      }
    }
    if (currentMax == 0 || topFan == null) {
      System.out.println("No plays, therefore no top fan");
      return topFan;
    }
    return topFan;
  }

  public int getDifferentUserCount() {
    return trackPlays.keySet().size();
  }
}
