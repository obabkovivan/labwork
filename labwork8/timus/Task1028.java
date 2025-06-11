package org.example.labwork8.timus;

import java.util.*;

public class Task1028 {
    static int MAX = 32001;
    static int[] bit = new int[MAX];

    static void update(int index, int value) {
        while (index < MAX) {
            bit[index] += value;
            index += index & -index;
        }
    }

    static int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] levelCount = new int[N];

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int level = query(x + 1);
            levelCount[level]++;
            update(x + 1, 1);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(levelCount[i]);
        }
    }
}

