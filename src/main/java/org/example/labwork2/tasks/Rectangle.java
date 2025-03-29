package org.example.labwork2.tasks;

import lombok.Data;

@Data
public class Rectangle {
    private double length;
    private double width;

    public Rectangle(){

    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle{length=" + length + ", width=" + width + "}";
    }
}
