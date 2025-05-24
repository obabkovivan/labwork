package org.example.labwork3.tasks;

import java.util.Scanner;

public class SecondTask {

    public static String toBinary(int number) {
        if (number == 0) {
            return "0";
        }
        return toBinaryHelper(number);
    }
    private static String toBinaryHelper(int number) {
        if (number == 0) {
            return "";
        }
        return toBinaryHelper(number / 2) + (number % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();
        String binary = toBinary(number);
        System.out.println("Двоичное представление: " + binary);
    }
}
