/*
 * Samuel Wu
 * 2024-09-12
 */

package homework.homework01;

public class Prize {
    public static final String DELIMITER = "\t";
    public static final int NUMBER_OF_FIELDS = 2;

    private String name;
    private double price;

    public Prize() {
        name = "none";
        price = 0.0;
    }

    public Prize(String name, double price) {
        setName(name);
        setPrice(price);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        } else {
            this.price = 0.0;
        }
    }

    @Override
    public String toString() {
        return "Prize: " + name + " Price: " + price;
    }

    public boolean equals(Prize other) {
        return other != null && name.equals(other.getName()) && price == other.getPrice();
    }
}
