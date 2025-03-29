package org.example.labwork2.timus;

import java.util.*;

public class Task1197 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] moves = {
                {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
                {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
        };
        List<Integer> counts =  new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String position = scanner.nextLine();
            int x = position.charAt(0) - 'a' + 1;
            int y = position.charAt(1) - '0';

            int count = 0;
            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];
                if (newX >= 1 && newX <= 8 && newY >= 1 && newY <= 8) {
                    count++;
                }
            }
            counts.add(count);
        }
        counts.forEach(System.out::println);
    }
}
