package org.sachindramaharjan.factory;

public class Circle {

    private String color;

    public Circle() {
        this.color = "White";
    }

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle [color=" + color + "]";
    }

}