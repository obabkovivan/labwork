package org.example.labwork3.tasks;

import java.util.Scanner;

public class ThirdTask {

    public static void inputArray(int[] arr, int index, Scanner scanner) {
        if (index >= arr.length) return;

        System.out.printf("Введите элемент [%d]: ", index);
        arr[index] = scanner.nextInt();
        inputArray(arr, index + 1, scanner);
    }

    public static void outputArray(int[] arr, int index) {
        if (index >= arr.length) return;

        System.out.printf("Элемент [%d]: %d%n", index, arr[index]);
        outputArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Ввод элементов массива:");
        inputArray(arr, 0, scanner);

        System.out.println("Вывод элементов массива:");
        outputArray(arr, 0);
    }
}
