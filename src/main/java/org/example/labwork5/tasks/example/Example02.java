package org.example.labwork5.tasks.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Размер массива: ");
        int size = scanner.nextInt();
        int[] arr1 = new Random().ints(size, 0, 200).toArray();
        int[] arr2 = new Random().ints(size, 0, 200).toArray();
        System.out.printf("Первый массив: %s\n", Arrays.toString(arr1));
        System.out.printf("Второй массив: %s\n", Arrays.toString(arr2));
        System.out.printf("Массив после фильтра: %s", Arrays.toString(filter(arr1, arr2)));
    }

    private static int[] filter(int[] arr1, int[] arr2){
        return Arrays.stream(arr1).filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x)).toArray();
    }
}
