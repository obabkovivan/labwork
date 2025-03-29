package org.example.labwork2.tasks.Animals;

import org.example.labwork2.tasks.Supports.Animal;

public class Bird extends Animal {
    private final boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    public void fly() {
        if (canFly) {
            System.out.println(name + " летает");
        } else {
            System.out.println(name + " не умеет летать");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(name + " чирикает");
    }

    @Override
    public String toString() {
        return "Bird{name='" + name + "', age=" + age + ", canFly=" + canFly + "}";
    }
}
