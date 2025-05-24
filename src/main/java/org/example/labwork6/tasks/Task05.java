package org.example.labwork6.tasks;

import java.util.concurrent.*;
import java.util.*;

public class Task05 {
    public static int findMax(int[] array) throws InterruptedException, ExecutionException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Integer>> results = new ArrayList<>();

        int chunk = (int) Math.ceil((double) array.length / cores);

        for (int i = 0; i < array.length; i += chunk) {
            int start = i;
            int end = Math.min(array.length, i + chunk);
            results.add(executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    max = Math.max(max, array[j]);
                }
                return max;
            }));
        }

        executor.shutdown();
        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> result : results) {
            globalMax = Math.max(globalMax, result.get());
        }
        return globalMax;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {3, 17, 5, 99, 25, 33, 41, 88, 7, 61};
        System.out.println("Max: " + findMax(arr));
    }
}

