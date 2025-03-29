package org.example.labwork2.tasks.ShapeExtend;

import lombok.Getter;
import lombok.Setter;
import org.example.labwork2.tasks.Supports.ShapeAbstract;

@Setter
@Getter
public class CircleExtend extends ShapeAbstract {
    private double radius;

    public CircleExtend(double radius) {
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
}
