package org.example;


import org.example.labwork2.tasks.Animals.Bird;
import org.example.labwork2.tasks.Animals.Cat;
import org.example.labwork2.tasks.Animals.Dog;
import org.example.labwork2.tasks.Person;
import org.example.labwork2.tasks.Rectangle;
import org.example.labwork2.tasks.SavingsAccount;
import org.example.labwork2.tasks.ShapeExtend.CircleExtend;
import org.example.labwork2.tasks.ShapeExtend.SquareExtend;
import org.example.labwork2.tasks.ShapeExtend.TriangleExtend;
import org.example.labwork2.tasks.ShapesImplement.*;
import org.example.labwork2.tasks.Supports.BankAccount;
import org.example.labwork2.tasks.Supports.Gender;
import org.example.labwork2.tasks.Supports.ShapeAbstract;
import org.example.labwork2.tasks.Supports.ShapeInterface;

public class Main {
    public static void main(String[] args) {

        //Человек
        Person person = new Person("Ivan", 23, Gender.MALE);
        person.setGender(Gender.FEMALE);
        System.out.println("Человек: \n" + person);

        //Прямоугольник
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(5);
        rectangle.setWidth(10);
        System.out.println("\nПрямоугольник: \n" + rectangle);
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());

        //Фигуры
        ShapeInterface circle = new Circle(5);
        ShapeInterface square = new Square(4);
        ShapeInterface triangle = new Triangle(3, 4, 5);
        System.out.println("\nФигуры:");

        System.out.println(circle + ", Площадь: " + circle.getArea() + ", Периметр: " + circle.getPerimeter());
        System.out.println(square + ", Площадь: " + square.getArea() + ", Периметр: " + square.getPerimeter());
        System.out.println(triangle + ", Площадь: " + triangle.getArea() + ", Периметр: " + triangle.getPerimeter());

        //Банк
        BankAccount myAccount = new SavingsAccount(1000.0);

        System.out.println("\nБанк: \nНачальный баланс: " + myAccount.getBalance());

        myAccount.deposit(500.0);
        System.out.println("Баланс после депозита: " + myAccount.getBalance());

        myAccount.withdraw(300.0);
        System.out.println("Баланс после снятия: " + myAccount.getBalance());

        myAccount.withdraw(1500.0);

        System.out.println("Финальный баланс: " + myAccount.getBalance());

        //Животные
        Dog dog = new Dog("Бобик", 3, "Овчарка");
        Cat cat = new Cat("Мурка", 2, "Рыба");
        Bird bird = new Bird("Кеша", 1, true);

        System.out.println("\nЖивотные: \n" + dog);
        dog.makeSound();
        dog.wagTail();

        System.out.println(cat);
        cat.makeSound();
        cat.purr();

        System.out.println(bird);
        bird.makeSound();
        bird.fly();

        //Наследование фигур
        ShapeAbstract circleExtend = new CircleExtend(5);
        ShapeAbstract squareExtend = new SquareExtend(4);
        ShapeAbstract triangleExtend = new TriangleExtend(3, 4, 5);

        System.out.println("\nНаследование фигур: \n"+ circleExtend);
        System.out.println(squareExtend);
        System.out.println(triangleExtend);
    }
}