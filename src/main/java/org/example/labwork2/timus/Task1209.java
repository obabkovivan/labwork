package org.example.labwork2.timus;

import java.util.*;

public class Task1209 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] positions = new int[n];

        for (int i = 0; i < n; i++) {
            positions[i] = Integer.parseInt(scanner.nextLine());
        }

        OptionalInt maxElement = Arrays.stream(positions).max();
        StringBuilder stringPowTen = new StringBuilder();
        int power = 0;

        while (stringPowTen.length() <= maxElement.getAsInt()) {
            stringPowTen.append((int)Math.pow(10, power));
            power++;
        }

        for (int pos : positions) {
            System.out.print(stringPowTen.charAt(pos-1) + " ");
        }
    }
}
