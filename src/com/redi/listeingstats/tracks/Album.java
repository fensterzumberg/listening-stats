package com.redi.listeingstats.tracks;

import java.util.Objects;
import java.util.UUID;

public class Album {
  private UUID id;
  private String name;
  private Artist artist;

  public Album(final String name, final Artist artist) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.artist = artist;
  }

  public String name() {
    return name;
  }

  public Artist artist() {
    return artist;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Album album = (Album) o;
    return Objects.equals(name, album.name) &&
           Objects.equals(artist, album.artist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, artist);
  }

  @Override
  public String toString() {
    return name;
  }
}
