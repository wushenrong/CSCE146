/*
 * Samuel Wu
 * 2024-11-09
 */

package labs.lab07;

public class Fruit implements Comparable<Fruit> {
    public static final int NUMBER_OF_FIELDS = 2;
    public static final String DELIMITER = "\t";

    public static final String TYPE_APPLE = "Apple";
    public static final String TYPE_ORANGE = "Orange";
    public static final String TYPE_BANANA = "Banana";
    public static final String TYPE_KIWI = "Kiwi";
    public static final String TYPE_TOMATO = "Tomato";

    private String type;
    private double weight;

    public Fruit() {
        type = TYPE_APPLE;
        weight = 1.0;
    }

    public Fruit(String type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (isTypeValid(type)) {
            this.type = type;
        } else {
            this.type = TYPE_APPLE;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0.0) {
            this.weight = weight;
        } else {
            this.weight = 1.0;
        }
    }

    @Override
    public String toString() {
        return "Type: " + type + DELIMITER + "Weight: " + weight;
    }

    /**
     * Compare a fruit to another by their weights, if the current fruit is less
     * than the other fruit, return -1. If the current fruit is greater than the
     * other fruit, return 1. Else return -1, 1, or 0 by comparing their type
     * alphabetically.
     */
    @Override
    public int compareTo(Fruit other) {
        if (other == null) {
            return -1;
        }

        if (weight < other.weight) {
            return -1;
        }

        if (weight > other.weight) {
            return 1;
        }

        return type.compareTo(other.type);
    }

    /**
     * Check if the type of the fruit is either an apple, orange, banana, kiwi,
     * or tomato.
     */
    private boolean isTypeValid(String fruitType) {
        return fruitType.equals(TYPE_APPLE) || fruitType.equals(TYPE_ORANGE) || fruitType.equals(TYPE_BANANA)
                || fruitType.equals(TYPE_KIWI) || fruitType.equals(TYPE_TOMATO);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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

        Fruit other = (Fruit) obj;

        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }

        return Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight);
    }
}
