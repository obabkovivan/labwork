package org.example.labwork3.tasks;

import java.util.HashMap;
import java.util.Map;

public class FifthTask {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        System.out.println("Строки с ключами > 5:");
        map.entrySet().stream()
                .filter(entry -> entry.getKey() > 5)
                .map(Map.Entry::getValue)
                .forEach(System.out::println);

        System.out.print("\nСтроки с ключом = 0 (через запятую): ");
        if (map.containsKey(0)) {
            System.out.println(map.get(0));
        }

        int product = map.entrySet().stream()
                .filter(entry -> entry.getValue().length() > 5)
                .map(Map.Entry::getKey)
                .reduce(1, (a, b) -> a * b);

        System.out.println("\nПроизведение ключей, где длина строки > 5: " + product);
    }
}

