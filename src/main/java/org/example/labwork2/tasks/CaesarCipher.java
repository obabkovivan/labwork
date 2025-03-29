package org.example.labwork2.tasks;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования");
        String text = scanner.nextLine();

        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        scanner.nextLine();

        String encryptedText = caesarCipher(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("y")) {
                System.out.println("Текст после обратного преобразования: " + caesarCipher(encryptedText, -key));
                break;
            } else if (response.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ.");
            }
        }

        scanner.close();
    }

    private static String caesarCipher(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append((char) (c + key));
        }
        return result.toString();
    }
}
