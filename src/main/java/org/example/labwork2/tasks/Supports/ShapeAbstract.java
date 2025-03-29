package org.example.labwork2.tasks.Supports;

public abstract class ShapeAbstract {
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{Area=" + getArea() + ", Perimeter=" + getPerimeter() + "}";
    }
}
