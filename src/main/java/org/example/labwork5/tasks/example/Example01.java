package org.example.labwork5.tasks.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example01 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Размер массива: ");
        int size = in.nextInt();

        int[] arr = new Random().ints(size).toArray();

        System.out.printf("Полученный массив: %s \n", Arrays.toString(arr));
        System.out.printf("Полученный массив после фильтра: %s", Arrays.toString(filter(arr)));
    }

    private static int[] filter(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }
}
