/*
 * Samuel Wu
 * 2024-10-10
 */

package homework.homework03;

public class Task {
    public static final int NUMBER_OF_PRIORITIES = 5;
    public static final int DEFAULT_PRIORITY = 4;

    public static final String DELIMITER = "\t";
    public static final int NUMBER_OF_FIELDS = 2;

    private int priority;
    private String action;

    public Task() {
        priority = DEFAULT_PRIORITY;
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
            this.priority = DEFAULT_PRIORITY;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + priority;
        result = prime * result + ((action == null) ? 0 : action.hashCode());
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

        Task other = (Task) obj;

        if (priority != other.priority) {
            return false;
        }

        if (action == null) {
            if (other.action != null) {
                return false;
            }
        } else if (!action.equals(other.action)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return priority + DELIMITER + action;
    }
}
