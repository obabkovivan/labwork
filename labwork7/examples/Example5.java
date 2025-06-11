package org.example.labwork7.examples;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Example5 {

    public static void main(String[] args) {
        String inputFileName = "src/lr8/examples/input.txt";
        String outputFileName = "src/lr8/examples/output.txt";
        File inputFile = new File(inputFileName);

        File dir = new File(inputFile.getParent());
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (created) {
                System.out.println("Папки созданы: " + dir.getPath());
            } else {
                System.out.println("Не удалось создать папки: " + dir.getPath());
                return;
            }
        }

        if (!inputFile.exists()) {
            try {
                if (inputFile.createNewFile()) {
                    System.out.println("Создан пустой файл: " + inputFileName);
                    Files.write(Paths.get(inputFileName),
                            "Hello, world!\nЭто тест.".getBytes(StandardCharsets.UTF_8));
                    System.out.println("В файл добавлен тестовый текст.");
                } else {
                    System.out.println("Не удалось создать input.txt.");
                    return;
                }
            } catch (IOException e) {
                System.out.println("Ошибка при создании input.txt: " + e.getMessage());
                return;
            }
        }

        try (
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(
                                new FileInputStream(inputFileName), StandardCharsets.UTF_8));
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream(outputFileName), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }
            System.out.println("Данные записаны в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
