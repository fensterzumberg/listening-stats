package com.redi.listeingstats.statistics;

import com.redi.listeingstats.tracks.Artist;
import com.redi.listeingstats.tracks.Track;
import java.util.HashMap;
import java.util.Map;

public class UserStatistics {
  Map<Track, Integer> trackPlays = new HashMap<>();
  Map<Artist, Integer> artistPlays = new HashMap<>();

  public Track getFavoriteTrack() {
    int currentMax = 0;
    Track maxTrack = null;
    for(Track t : trackPlays.keySet()) {
      int trackNumber = trackPlays.get(t);
      if (trackNumber > currentMax) {
        currentMax = trackNumber;
        maxTrack = t;
      }
    }
    if (currentMax == 0 || maxTrack == null) {
      System.out.println("No plays, therefore no top track");
      return maxTrack;
    }
    return maxTrack;
  }

  public Artist getFavoriteArtist() {
    int currentMax = 0;
    Artist maxArtist = null;
    for(Artist t : artistPlays.keySet()) {
      int trackNumber = artistPlays.get(t);
      if (trackNumber > currentMax) {
        currentMax = trackNumber;
        maxArtist = t;
      }
    }
    if (currentMax == 0 || maxArtist == null) {
      System.out.println("No plays, therefore no top artist");
      return maxArtist;
    }
    return maxArtist;
  }

  public void recordPlay(final Track track) {
    int totalTrackPlays = this.trackPlays.getOrDefault(track, 0) + 1;
    this.trackPlays.put(track, totalTrackPlays);
    int totalArtistPlays = this.artistPlays.getOrDefault(track.artist(), 0) + 1;
    this.artistPlays.put(track.artist(), totalArtistPlays);
  }
}
