package org.example.labwork5.tasks.example;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example03 {
    private static final Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.print("Количество предложений: ");
        String string = String.join(" ", faker.lorem().sentences(new Scanner(System.in).nextInt()));
        System.out.println(string);
        System.out.printf("Строка после сплита: %s\n", Arrays.asList(string.split(" ")));
        System.out.printf("Строка после фильтра: %s", filter(Arrays.asList(string.split(" "))));
    }
    private static List<String> filter(List<String> list){
        return list.stream().filter(s -> Character.isUpperCase(s.charAt(0))).collect(Collectors.toList());
    }
}
