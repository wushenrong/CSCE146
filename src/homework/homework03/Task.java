/*
 * Samuel Wu
 * 2024-10-10
 */

package homework.homework03;

public class Task {
    public static final int NUMBER_OF_PRIORITIES = 5;

    public static final String DELIMITER = "\t";
    public static final int NUMBER_OF_FIELDS = 2;

    private int priority;
    private String action;

    public Task() {
        priority = 4;
        action = "none";
    }

    public Task(int priority, String action) {
        setPriority(priority);
        setAction(action);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority >= 0 && priority < NUMBER_OF_PRIORITIES) {
            this.priority = priority;
        } else {
            this.priority = 4;
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        if (action != null) {
            this.action = action;
        } else {
            this.action = "none";
        }
    }

    public boolean equals(Task other) {
        return other != null && this.priority == other.getPriority() && this.action.equals(other.getAction());
    }

    @Override
    public String toString() {
        return priority + DELIMITER + action;
    }
}
