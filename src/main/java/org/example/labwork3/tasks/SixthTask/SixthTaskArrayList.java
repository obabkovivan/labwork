package org.example.labwork3.tasks.SixthTask;

import java.util.ArrayList;
import java.util.List;

public class SixthTaskArrayList {

    public static void main(String[] args) {
        int n = 10000;
        long start = System.currentTimeMillis();
        int survivor = simulateWithArrayList(n);
        long end = System.currentTimeMillis();
        System.out.println("Выживший (ArrayList): " + survivor);
        System.out.println("Время (мс): " + (end - start));
    }

    private static int simulateWithArrayList(int n) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }

        return people.get(0);
    }
}

