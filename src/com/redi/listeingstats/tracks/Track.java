package com.redi.listeingstats.tracks;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Track {

  private UUID id;
  private String name;
  private Artist artist;
  private Optional<Album> album;

  public Track(final String name, final Artist artist) {
    this(name, artist, Optional.empty());
  }

  public Track(final String name, final Artist artist, final Album album) {
    this(name, artist, Optional.of(album));
  }

  private Track(final String name, final Artist artist, final Optional<Album> album) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.artist = artist;
    this.album = album;
  }

  public Artist artist() {
    return artist;
  }

  public String name() {
    return name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Track track = (Track) o;
    return Objects.equals(name, track.name) &&
           Objects.equals(artist, track.artist) &&
           Objects.equals(album, track.album);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, artist, album);
  }

  @Override
  public String toString() {
    return name;
  }
}
