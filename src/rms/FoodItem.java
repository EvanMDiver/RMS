package rms;

public class FoodItem {
    public String name;
    public double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public enum StatusEnum {}

    public StatusEnum status;


    @Override
    public String toString() {
        return name;
    }
}
