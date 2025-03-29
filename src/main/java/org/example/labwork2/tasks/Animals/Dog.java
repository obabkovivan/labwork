package org.example.labwork2.tasks.Animals;

import org.example.labwork2.tasks.Supports.Animal;

public class Dog extends Animal {
    private final String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void wagTail() {
        System.out.println(name + " виляет хвостом");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " лает");
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + age + ", breed='" + breed + "'}";
    }
}
