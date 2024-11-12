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
    public static final String TYPE_KIWI = "KIWI";
    public static final String TYPE_TOMATO = "TOMATO";

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
        if (isTypeValid(type))
            this.type = type;
        else
            this.type = TYPE_APPLE;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0.0)
            this.weight = weight;
        else
            this.weight = 1.0;
    }

    @Override
    public String toString() {
        return "Type: " + type + " Weight: " + weight;
    }

    @Override
    public int compareTo(Fruit other) {
        if (other == null)
            return -1;

        if (other.getWeight() > weight)
            return -1;

        if (other.getWeight() < weight)
            return 1;

        return other.getType().compareTo(type);
    }

    private boolean isTypeValid(String type) {
        return type.equals(TYPE_APPLE) || type.equals(TYPE_ORANGE) || type.equals(TYPE_BANANA) || type.equals(TYPE_KIWI)
                || type.equals(TYPE_TOMATO);
    }
}
