package org.example.labwork2.tasks.ShapesImplement;

import lombok.Data;
import org.example.labwork2.tasks.Supports.ShapeInterface;

@Data
public class Circle implements ShapeInterface {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + "}";
    }
}
