package org.example.labwork4.tasks.mission;

import java.util.*;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] arr = new int[5];
            int sum = 0;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(sc.nextLine());
                if (arr[i] > 0) {
                    sum += arr[i];
                    count++;
                }
            }
            if (count == 0) throw new Exception("Нет положительных элементов");
            System.out.println("Среднее: " + (sum / (double) count));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

