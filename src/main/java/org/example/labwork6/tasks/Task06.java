package org.example.labwork6.tasks;

import java.util.concurrent.*;
import java.util.*;

public class Task06 {
    public static int parallelSum(int[] array) throws InterruptedException, ExecutionException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Integer>> results = new ArrayList<>();

        int chunk = (int) Math.ceil((double) array.length / cores);

        for (int i = 0; i < array.length; i += chunk) {
            int start = i;
            int end = Math.min(array.length, i + chunk);
            results.add(executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            }));
        }

        executor.shutdown();
        int totalSum = 0;
        for (Future<Integer> result : results) {
            totalSum += result.get();
        }
        return totalSum;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Sum: " + parallelSum(arr));
    }
}

