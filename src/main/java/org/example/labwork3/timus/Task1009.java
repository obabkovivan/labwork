package org.example.labwork3.timus;

import java.util.Scanner;

public class Task1009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        long[][] dp = new long[N + 1][2];

        dp[1][0] = 0;
        dp[1][1] = K - 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (K - 1) * (dp[i - 1][0] + dp[i - 1][1]);
        }

        long result = dp[N][0] + dp[N][1];
        System.out.println(result);
    }
}
