package org.example.labwork5.timus;

import java.util.*;

public class Task1014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if (N == 0) {
            System.out.println(10);
            return;
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }

        List<Integer> digits = new ArrayList<>();

        for (int d = 9; d >= 2; d--) {
            while (N % d == 0) {
                N /= d;
                digits.add(d);
            }
        }

        if (N != 1) {
            System.out.println(-1);
            return;
        }

        Collections.sort(digits);
        for (int digit : digits) {
            System.out.print(digit);
        }
    }
}
