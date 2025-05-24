package org.example.labwork5.tasks;

import java.util.*;
import java.util.stream.*;

public class FunctionalLab {

    public static int[] filterEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .toArray();
    }

    public static int[] intersectArrays(int[] a, int[] b) {
        Set<Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a)
                .filter(setB::contains)
                .toArray();
    }

    public static List<String> filterCapitalized(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<Integer> divisibleBy(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }

    public static List<String> longerThan(List<String> list, int length) {
        return list.stream()
                .filter(s -> s.length() > length)
                .collect(Collectors.toList());
    }

    public static List<Integer> greaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }

    public static List<String> onlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Z]+"))
                .collect(Collectors.toList());
    }

    public static List<Integer> lessThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }
}

