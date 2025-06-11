package org.example.labwork7.timus;

import java.util.*;

public class Task1025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int[] groups = new int[K];

        for (int i = 0; i < K; i++) {
            groups[i] = scanner.nextInt();
        }

        Arrays.sort(groups);

        int majorityGroups = K / 2 + 1;
        int minSupporters = 0;

        for (int i = 0; i < majorityGroups; i++) {
            minSupporters += groups[i] / 2 + 1;
        }

        System.out.println(minSupporters);
    }
}
