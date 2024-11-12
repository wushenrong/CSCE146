/*
 * Samuel Wu
 * 2024-10-08
 */

package labs.lab05;

public class Process {
    private String name;
    private double completionTime;

    public Process() {
        name = "none";
        completionTime = 0.0;
    }

    public Process(String name, double completionTime) {
        setName(name);
        setCompletionTime(completionTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "none";
        }
    }

    public double getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(double completionTime) {
        if (completionTime >= 0.0) {
            this.completionTime = completionTime;
        } else {
            this.completionTime = 0.0;
        }
    }

    @Override
    public String toString() {
        return "Process Name: " + name + " Completion Time: " + completionTime;
    }
}
