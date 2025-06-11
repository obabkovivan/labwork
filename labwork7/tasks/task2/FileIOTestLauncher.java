package org.example.labwork7.tasks.task2;

import org.example.labwork7.entity.Person;
import org.example.labwork7.entity.Student;

import java.util.Scanner;

public class FileIOTestLauncher {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Выберите действие:");
        System.out.println("1  — Байтовый ввод/вывод (FileOutputStream / FileInputStream)");
        System.out.println("2  — Символьный ввод/вывод (FileWriter / FileReader)");
        System.out.println("3  — Буферизированный ввод/вывод (BufferedWriter / BufferedReader)");
        System.out.println("4  — Потоки с кодировкой (OutputStreamWriter / InputStreamReader)");
        System.out.println("5  — Использование PrintWriter для записи в файл");
        System.out.println("6  — Поиск строк по слову: выводит все строки файла, содержащие заданное слово");
        System.out.println("7  — Запись текста в файл и вывод количества записанных символов");
        System.out.println("8  — Сериализация и десериализация объекта с выводом значений полей");
        System.out.println("9  — Подсчёт количества строк в заданном текстовом файле");
        System.out.println("10 — Копирование содержимого одного текстового файла в другой");
        System.out.println("11 — Определение размера файла в байтах");
        System.out.println("12 — Поиск и вывод строк, содержащих слово (дублирует пункт 6)");
        System.out.println("13 — Запись текста в указанный файл и подсчёт символов (дублирует пункт 7)");
        System.out.println("14 — Сериализация и восстановление объекта Student (дублирует пункт 8)");


        System.out.print("Введите номер варианта: ");
        int choice = Integer.parseInt(scanner.nextLine());

        String path = "test.txt";

        switch (choice) {
            case 1, 2, 3, 4, 5, 7 -> {
                System.out.print("Введите строку для записи: ");
                String data = scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        FileIOUtil.writeBytes(path, data);
                        FileIOUtil.readBytes(path);
                    }
                    case 2 -> {
                        FileIOUtil.writeText(path, data);
                        FileIOUtil.readText(path);
                    }
                    case 3 -> {
                        FileIOUtil.writeBuffered(path, data);
                        FileIOUtil.readBuffered(path);
                    }
                    case 4 -> {
                        FileIOUtil.writeWithEncoding(path, data, "UTF-8");
                        FileIOUtil.readWithEncoding(path, "UTF-8");
                    }
                    case 5 -> {
                        FileIOUtil.writeWithPrintWriter(path, data, "UTF-8");
                        FileIOUtil.readBufferedLines(path);
                    }
                    case 7 -> {
                        int count = FileIOUtil.writeAndCountChars(path, data);
                        System.out.println("Количество записанных символов: " + count);
                    }
                }
            }
            case 6 -> {
                System.out.print("Введите путь к файлу: ");
                String filePath = scanner.nextLine();
                System.out.print("Введите слово для поиска: ");
                String word = scanner.nextLine();
                FileIOUtil.findLinesWithWord(filePath, word);
            }
            case 8 -> {
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                System.out.print("Введите возраст: ");
                int age = Integer.parseInt(scanner.nextLine());

                Person person = new Person(name, age);
                String objPath = "person.ser";
                FileIOUtil.serializeObject(objPath, person);
                Object deserialized = FileIOUtil.deserializeObject(objPath);
                System.out.println("Объект восстановлен: " + deserialized);
                FileIOUtil.deleteFile(objPath);
            }
            case 9 -> {
                System.out.print("Введите путь к файлу: ");
                String filePath = scanner.nextLine();
                int lineCount = FileIOUtil.countLines(filePath);
                System.out.println("Количество строк: " + lineCount);
            }
            case 10 -> {
                System.out.print("Введите исходный файл: ");
                String source = scanner.nextLine();
                System.out.print("Введите файл назначения: ");
                String dest = scanner.nextLine();
                FileIOUtil.copyFile(source, dest);
                System.out.println("Копирование завершено.");
            }
            case 11 -> {
                System.out.print("Введите имя файла: ");
                String fileName = scanner.nextLine();
                long size = FileIOUtil.getFileSize(fileName);
                if (size >= 0)
                    System.out.println("Размер файла: " + size + " байт");
                else
                    System.out.println("Файл не существует.");
            }
            case 12 -> {
                System.out.print("Введите имя файла: ");
                path = scanner.nextLine();
                System.out.print("Введите слово: ");
                String word = scanner.nextLine();
                FileIOUtil.findLinesWithWord1(path, word);
            }
            case 13 -> {
                System.out.print("Введите имя файла: ");
                path = scanner.nextLine();
                System.out.print("Введите текст: ");
                String data = scanner.nextLine();
                int chars = FileIOUtil.writeAndCountChars1(path, data);
                System.out.println("Количество записанных символов: " + chars);
            }
            case 14 -> {
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                System.out.print("Введите возраст: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите средний балл: ");
                double gpa = Double.parseDouble(scanner.nextLine());

                Student student = new Student(name, age, gpa);
                path = "student.ser";

                FileIOUtil.serializeObject(path, student);
                Object obj = FileIOUtil.deserializeObject(path);
                System.out.println("Объект восстановлен: " + obj);
                FileIOUtil.deleteFile(path);
            }
            default -> System.out.println("Неверный выбор.");
        }

        FileIOUtil.deleteFile(path);
    }
}

