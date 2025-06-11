package org.example.labwork8.tasks;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class Task3 {
    static final String PATH = "books.json";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:\n1 - Добавить\n2 - Поиск\n3 - Удалить");
        switch (scanner.nextLine()) {
            case "1" -> addBook(scanner);
            case "2" -> searchBook(scanner);
            case "3" -> deleteBook(scanner);
        }
    }

    static JSONObject loadJson() throws Exception {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new FileReader(PATH));
    }

    static void saveJson(JSONObject obj) throws Exception {
        try (FileWriter writer = new FileWriter(PATH)) {
            writer.write(obj.toJSONString());
        }
    }

    static void addBook(Scanner scanner) throws Exception {
        JSONObject root = loadJson();
        JSONArray books = (JSONArray) root.get("books");

        JSONObject book = new JSONObject();
        System.out.print("Название: ");
        book.put("title", scanner.nextLine());
        System.out.print("Автор: ");
        book.put("author", scanner.nextLine());
        System.out.print("Год: ");
        book.put("year", scanner.nextLine());

        books.add(book);
        saveJson(root);
        System.out.println("Книга добавлена.");
    }

    static void searchBook(Scanner scanner) throws Exception {
        JSONObject root = loadJson();
        JSONArray books = (JSONArray) root.get("books");

        System.out.print("Автор: ");
        String author = scanner.nextLine();

        for (Object obj : books) {
            JSONObject book = (JSONObject) obj;
            if (author.equalsIgnoreCase((String) book.get("author"))) {
                System.out.println("Найдено: " + book.get("title"));
            }
        }
    }

    static void deleteBook(Scanner scanner) throws Exception {
        JSONObject root = loadJson();
        JSONArray books = (JSONArray) root.get("books");

        System.out.print("Название для удаления: ");
        String title = scanner.nextLine();

        Iterator<?> iterator = books.iterator();
        while (iterator.hasNext()) {
            JSONObject book = (JSONObject) iterator.next();
            if (title.equalsIgnoreCase((String) book.get("title"))) {
                iterator.remove();
                saveJson(root);
                System.out.println("Удалено.");
                return;
            }
        }
        System.out.println("Книга не найдена.");
    }
}

