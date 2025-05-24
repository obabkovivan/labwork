package org.example.labwork4.tasks.mission;

import java.util.*;

public class Task03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            byte[] arr = new byte[5];
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                int temp = Integer.parseInt(sc.nextLine());
                if (temp < Byte.MIN_VALUE || temp > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Выход за пределы byte");
                }
                arr[i] = (byte) temp;
                sum += arr[i];
            }
            System.out.println("Сумма: " + sum);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

