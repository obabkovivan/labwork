package org.example.labwork6.timus;

import java.util.Scanner;

public class Task1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = scanner.nextInt();
        int[] first = new int[N1];
        for (int i = 0; i < N1; i++) {
            first[i] = scanner.nextInt();
        }

        int N2 = scanner.nextInt();
        int[] second = new int[N2];
        for (int i = 0; i < N2; i++) {
            second[i] = scanner.nextInt();
        }

        int i = 0, j = 0;
        boolean found = false;
        while (i < N1 && j < N2) {
            int sum = first[i] + second[j];
            if (sum == 10000) {
                found = true;
                break;
            } else if (sum < 10000) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println(found ? "YES" : "NO");
    }
}

