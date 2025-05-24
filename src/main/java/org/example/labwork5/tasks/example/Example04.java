package org.example.labwork5.tasks.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example04 {
    public static void main(String[] args) {

        List<Integer> arr = new Random()
                .ints(10, 0, 1001)
                .boxed()
                .collect(Collectors.toList());
        System.out.printf("Массив: %s\n", arr);

        System.out.printf("Массив после обработки: %s", filter(arr));
    }

    private static List<Integer> filter(List<Integer> list) {
        return list.stream().map(x -> x * x)
                .collect(Collectors.toList());
    }
}
