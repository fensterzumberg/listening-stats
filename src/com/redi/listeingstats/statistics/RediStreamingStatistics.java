package com.redi.listeingstats.statistics;

public class RediStreamingStatistics {

  private int totalPlays = 0;

  public void recordPlay() {
    this.totalPlays = this.totalPlays + 1;
  }

  public int totalPlays() {
    return totalPlays;
  }
}
