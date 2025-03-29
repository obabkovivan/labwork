package org.example.labwork2.tasks;

import java.util.Arrays;

public class SnakeMatrix {
    public static void main(String[] args) {
        int n = 5, m = 8;
        int[][] matrix = new int[n][m];
        int num = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = num++;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    matrix[i][j] = num++;
                }
            }
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
