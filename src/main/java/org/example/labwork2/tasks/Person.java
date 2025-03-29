package org.example.labwork2.tasks;

import lombok.Data;
import org.example.labwork2.tasks.Supports.Gender;

@Data
public class Person {

    private String firstName;

    private int age;

    private Gender gender;

    public Person(){

    }

    public Person(String name, int age, Gender gender) {
        this.firstName = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{First name=" + firstName + ", age=" + age + ", gender=" + gender + "}";
    }
}