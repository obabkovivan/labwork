package org.example.labwork2.tasks.ShapesImplement;

import lombok.Data;
import org.example.labwork2.tasks.Supports.ShapeInterface;

@Data
public class Square implements ShapeInterface {
    private double side;

    public Square(){

    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square{side=" + side + "}";
    }

}
