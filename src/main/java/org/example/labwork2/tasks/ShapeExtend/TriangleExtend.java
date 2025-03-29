package org.example.labwork2.tasks.ShapeExtend;

import org.example.labwork2.tasks.Supports.ShapeAbstract;

public class TriangleExtend extends ShapeAbstract {
    private final double a;
    private final double b;
    private final double c;

    public TriangleExtend(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Стороны не образуют треугольник");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
