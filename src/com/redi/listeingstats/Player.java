package com.redi.listeingstats;

import com.redi.listeingstats.statistics.ArtistStatistics;
import com.redi.listeingstats.statistics.RediStreamingStatistics;
import com.redi.listeingstats.statistics.UserStatistics;
import com.redi.listeingstats.tracks.Artist;
import com.redi.listeingstats.tracks.Track;
import java.util.HashMap;
import java.util.Map;

public class Player {
  private RediStreamingStatistics rediStatistics;
  private Map<User, UserStatistics> userStatistics;
  private Map<Artist, ArtistStatistics> artistStatistics;

  public Player(){
    rediStatistics = new RediStreamingStatistics();
    userStatistics = new HashMap<>();
    artistStatistics = new HashMap<>();
  }

  public void play(Track track, User user) {
    rediStatistics.recordPlay();
    final UserStatistics userStatistics = this.userStatistics.getOrDefault(user, new UserStatistics());
    userStatistics.recordPlay(track);
    this.userStatistics.put(user, userStatistics);
    final ArtistStatistics artistStatistics = this.artistStatistics.getOrDefault(track.artist(), new ArtistStatistics());
    artistStatistics.recordPlay(user);
    this.artistStatistics.put(track.artist(), artistStatistics);
    System.out.println("User "+ user.name() + " plays the track "+ track.name());
  }

  public User getTopFanForArtist(Artist artist) {
    return artistStatistics.get(artist).getTopFan();
  }

  public int getArtistUserCount(Artist artist) {
    return artistStatistics.get(artist).getDifferentUserCount();
  }


  public Artist getTopArtistForFan(final User user) {
    return userStatistics.get(user).getFavoriteArtist();
  }

  public Track getTopTrackForFan(final User user) {
    return userStatistics.get(user).getFavoriteTrack();
  }
}
