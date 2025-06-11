package org.example.labwork7.timus;

import java.util.*;

public class Task1026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        List<Integer> database = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            database.add(Integer.parseInt(scanner.nextLine()));
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("#")) break;
        }

        int K = Integer.parseInt(scanner.nextLine());
        int[] queries = new int[K];

        for (int i = 0; i < K; i++) {
            queries[i] = Integer.parseInt(scanner.nextLine());
        }

        Collections.sort(database);

        for (int i = 0; i < K; i++) {
            System.out.println(database.get(queries[i] - 1));
        }
    }
}

