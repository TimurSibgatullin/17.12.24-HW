package org.example;

public class Apple implements CanCompare {

    private String color;
    private int weight;
    private String kind;
    private int price;

    public Apple(String color, int weight, String kind, int price) {
        this.color = color;
        this.weight = weight;
        this.kind = kind;
        this.price = price;
    }

    @Override
    public int compare(CanCompare other) {
        return this.price - ((Apple)other).price;
    }

    public int getPrice() {
        return price;
    }

    public String getKind() {
        return kind;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " " + weight + " " + kind + " " + price;
    }
}