package org.example.labwork7.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int age;
    private final double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Средний балл: " + gpa;
    }
}

