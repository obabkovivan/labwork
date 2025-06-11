package org.example.labwork8.timus;

import java.util.*;

public class Task1029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] cost = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                cost[i][j] = scanner.nextInt();

        int[][] dp = new int[M][N];
        int[][] path = new int[M][N];

        for (int j = 0; j < N; j++) {
            dp[0][j] = cost[0][j];
            path[0][j] = -1;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int min = dp[i - 1][j];
                int from = j;

                if (j > 0 && dp[i - 1][j - 1] < min) {
                    min = dp[i - 1][j - 1];
                    from = j - 1;
                }

                if (j < N - 1 && dp[i - 1][j + 1] < min) {
                    min = dp[i - 1][j + 1];
                    from = j + 1;
                }

                dp[i][j] = min + cost[i][j];
                path[i][j] = from;
            }
        }

        int minTotal = dp[M - 1][0];
        int endRoom = 0;
        for (int j = 1; j < N; j++) {
            if (dp[M - 1][j] < minTotal) {
                minTotal = dp[M - 1][j];
                endRoom = j;
            }
        }

        int[] result = new int[M];
        int current = endRoom;
        for (int i = M - 1; i >= 0; i--) {
            result[i] = current + 1;
            current = path[i][current];
        }

        for (int x : result)
            System.out.println(x);
    }
}
