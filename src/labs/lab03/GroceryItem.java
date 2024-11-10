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
        if (name != null)
            this.name = name;
        else
            this.name = "none";
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value >= 0.0)
            this.value = value;
        else
            this.value = 0.0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        GroceryItem other = (GroceryItem) obj;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;

        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Grocery Item Name: " + name + " Value: " + value;
    }
}
