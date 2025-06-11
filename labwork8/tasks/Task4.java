package org.example.labwork8.tasks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Task4 {
    public static void main(String[] args) {
        String url = "http://fat.urfu.ru/index.html";

        try {
            Document doc = Jsoup.connect(url).timeout(5000).get();
            Elements news = doc.select(".blocktitle, .blockdate");

            try (FileWriter writer = new FileWriter("news.txt")) {
                for (int i = 0; i < news.size(); i++) {
                    writer.write(news.get(i).text() + System.lineSeparator());
                }
                System.out.println("Новости сохранены.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
            System.out.println("Попробуйте еще раз позже.");
        }
    }
}

