package org.example.labwork2.tasks.Animals;

import org.example.labwork2.tasks.Supports.Animal;

public class Cat extends Animal {
    private final String favoriteFood;

    public Cat(String name, int age, String favoriteFood) {
        super(name, age);
        this.favoriteFood = favoriteFood;
    }

    public void purr() {
        System.out.println(name + " мурлычет");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " мяукает");
    }

    @Override
    public String toString() {
        return "Cat{name='" + name + "', age=" + age + ", favoriteFood='" + favoriteFood + "'}";
    }
}
