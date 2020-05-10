package com.redi.listeingstats.tracks;

import java.util.Objects;
import java.util.UUID;

public class Artist {
  private UUID id;
  private String name;

  public Artist(final String name) {
    this.id = UUID.randomUUID();
    this.name = name;
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
    final Artist artist = (Artist) o;
    return Objects.equals(name, artist.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
