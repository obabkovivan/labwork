package org.example.labwork5.timus;

import java.util.Scanner;

public class Task1017 {
    static int[][] memo;

    static int count(int n, int k) {
        if (n == 0) return 1;
        if (n < k) return 0;

        if (memo[n][k] != -1) return memo[n][k];

        int include = count(n - k, k + 1);
        int skip = count(n, k + 1);

        memo[n][k] = include + skip;
        return memo[n][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        memo = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= N; j++)
                memo[i][j] = -1;

        int result = count(N, 1) - 1;
        System.out.println(result);
    }
}
