package org.example.labwork2.timus;

import java.util.*;

public class Task1005 {
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] weights = new int[n];
        int totalWeight = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(input[i]);
            totalWeight += weights[i];
        }

        findMinDifference(weights, 0, 0, totalWeight);
        System.out.println(minDifference);
    }

    private static void findMinDifference(int[] weights, int index, int sum1, int totalWeight) {
        if (index == weights.length) {
            int sum2 = totalWeight - sum1;
            minDifference = Math.min(minDifference, Math.abs(sum1 - sum2));
            return;
        }

        findMinDifference(weights, index + 1, sum1 + weights[index], totalWeight);
        findMinDifference(weights, index + 1, sum1, totalWeight);
    }
}
