package com.redi.listeingstats;

import java.util.Objects;
import java.util.UUID;

public class User {
  private UUID id;
  private String name;

  public User(final String name) {
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
    final User user = (User) o;
    return Objects.equals(name, user.name);
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
