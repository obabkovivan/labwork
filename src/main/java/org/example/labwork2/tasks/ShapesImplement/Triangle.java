package org.example.labwork2.tasks.ShapesImplement;

import lombok.Getter;
import org.example.labwork2.tasks.Supports.ShapeInterface;

@Getter
public class Triangle implements ShapeInterface {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Стороны не образуют треугольник");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(double a) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Стороны не образуют треугольник");
        }
        this.a = a;
    }

    public void setB(double b) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Стороны не образуют треугольник");
        }
        this.b = b;
    }

    public void setC(double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Стороны не образуют треугольник");
        }
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

    @Override
    public String toString() {
        return "Triangle{a=" + a + ", b=" + b + ", c=" + c + "}";
    }
}
