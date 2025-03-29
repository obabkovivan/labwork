package org.example.labwork2.tasks.ShapeExtend;

import lombok.Getter;
import lombok.Setter;
import org.example.labwork2.tasks.Supports.ShapeAbstract;

@Setter
@Getter
public class SquareExtend extends ShapeAbstract {
    private double side;

    public SquareExtend(double side) {
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
}
