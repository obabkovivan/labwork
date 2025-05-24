package org.example.labwork4.timus;

import java.math.BigInteger;
import java.util.Scanner;

public class Task1012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        BigInteger[] prev = new BigInteger[2];
        BigInteger[] curr = new BigInteger[2];

        prev[0] = BigInteger.ZERO;
        prev[1] = BigInteger.valueOf(K - 1);

        for (int i = 2; i <= N; i++) {
            curr[0] = prev[1];
            curr[1] = BigInteger.valueOf(K - 1).multiply(prev[0].add(prev[1]));

            BigInteger[] temp = prev;
            prev = curr;
            curr = temp;
        }

        BigInteger result = prev[0].add(prev[1]);
        System.out.println(result);
    }
}
