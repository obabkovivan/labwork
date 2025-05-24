package org.example.labwork4.tasks.mission;

import java.util.*;

public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        try {
            int col = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][col]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Столбец не найден");
        }
    }
}

