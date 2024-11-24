/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework02;

public class VideoGame {
    public static final String DEFAULT_GAME_VALUE = "unknown";
    public static final String DELIMITER = "\t";
    public static final int NUMBER_OF_FIELDS = 2;

    private String name;
    private String console;

    public VideoGame() {
        name = DEFAULT_GAME_VALUE;
        console = DEFAULT_GAME_VALUE;
    }

    public VideoGame(String name, String console) {
        setName(name);
        setConsole(console);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = DEFAULT_GAME_VALUE;
        }
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        if (console != null) {
            this.console = console;
        } else {
            this.console = DEFAULT_GAME_VALUE;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((console == null) ? 0 : console.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        VideoGame other = (VideoGame) obj;

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        if (console == null) {
            if (other.console != null) {
                return false;
            }
        } else if (!console.equals(other.console)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return name + DELIMITER + console;
    }
}
