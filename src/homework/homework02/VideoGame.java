/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework02;

import java.util.Objects;

public class VideoGame {
  public static final String DELIMITER = "\t";
  public static final int NUMBER_OF_FIELDS = 2;

  public static final String DEFAULT_GAME_VALUE = "unknown";

  private String name;
  private String console;

  public VideoGame() {
    this(DEFAULT_GAME_VALUE, DEFAULT_GAME_VALUE);
  }

  public VideoGame(String name, String console) {
    setName(name);
    setConsole(console);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name != null ? name : DEFAULT_GAME_VALUE;
  }

  public String getConsole() {
    return console;
  }

  public void setConsole(String console) {
    this.console = console != null ? console : DEFAULT_GAME_VALUE;
  }

  @Override
  public String toString() {
    return name + DELIMITER + console;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, console);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof VideoGame)) {
      return false;
    }

    VideoGame other = (VideoGame) obj;
    return Objects.equals(name, other.name) && Objects.equals(console, other.console);
  }
}
