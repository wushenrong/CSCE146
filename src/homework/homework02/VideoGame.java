/*
 * Samuel Wu
 * 2024-09-25
 */

package homework.homework02;

public class VideoGame {
    public static final String DELIMITER = "\t";
    public static final int NUMBER_OF_FIELDS = 2;

    private String name;
    private String console;

    public VideoGame() {
        name = "unknown";
        console = "unknown";
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
            this.name = "unknown";
        }
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        if (console != null) {
            this.console = console;
        } else {
            this.console = "unknown";
        }
    }

    public boolean equals(VideoGame other) {
        return other != null && name.equals(other.getName()) && console.equals(other.getConsole());
    }

    @Override
    public String toString() {
        return name + DELIMITER + console;
    }
}
