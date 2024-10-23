/*
 * Samuel Wu
 * 2024-09-20
 */

package labs.lab03;

public class GroceryItem {
    private String name;
    private double value;

    public GroceryItem() {
        name = "none";
        value = 0.0;
    }

    public GroceryItem(String name, double value) {
        setName(name);
        setValue(value);
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value >= 0.0) {
            this.value = value;
        } else {
            this.value = 0.0;
        }
    }

    @Override
    public String toString() {
        return "Grocery Item Name: " + name + " Value: " + value;
    }

    public boolean equals(GroceryItem other) {
        return other != null && name.equals(other.getName()) && value == other.getValue();
    }
}
