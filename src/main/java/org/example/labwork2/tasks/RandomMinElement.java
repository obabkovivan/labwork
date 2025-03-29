package org.example.labwork2.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomMinElement {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = IntStream.generate(() -> random.nextInt(100) + 1).limit(100).toArray();

        int minVal = Arrays.stream(arr).min().getAsInt();
        List<Integer> minIndices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == minVal) {
                minIndices.add(i);
            }
        }
        System.out.println("Массив: " + Arrays.toString(arr));
        System.out.println("Минимальное значение: " + minVal);
        System.out.println("Индексы минимального элемента: " + minIndices);
    }
}
