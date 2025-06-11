package org.example.labwork7.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Имя: " + name + ", Возраст: " + age;
    }
}
