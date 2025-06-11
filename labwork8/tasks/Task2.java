package org.example.labwork8.tasks;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class Task2 {
    static final String PATH = "books.xml";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:\n1 - Добавить\n2 - Поиск\n3 - Удалить");
        switch (scanner.nextLine()) {
            case "1" -> addBook(scanner);
            case "2" -> searchBook(scanner);
            case "3" -> deleteBook(scanner);
        }
    }

    static Document loadXML() throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(new File(PATH));
    }

    static void saveXML(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult(new File(PATH)));
    }

    static void addBook(Scanner scanner) throws Exception {
        Document doc = loadXML();
        Element root = doc.getDocumentElement();

        Element book = doc.createElement("book");
        System.out.print("Название: ");
        Element title = doc.createElement("title");
        title.setTextContent(scanner.nextLine());
        book.appendChild(title);

        System.out.print("Автор: ");
        Element author = doc.createElement("author");
        author.setTextContent(scanner.nextLine());
        book.appendChild(author);

        System.out.print("Год: ");
        Element year = doc.createElement("year");
        year.setTextContent(scanner.nextLine());
        book.appendChild(year);

        root.appendChild(book);
        saveXML(doc);
        System.out.println("Книга добавлена.");
    }

    static void searchBook(Scanner scanner) throws Exception {
        Document doc = loadXML();
        NodeList books = doc.getElementsByTagName("book");

        System.out.print("Поиск по (author/year): ");
        String field = scanner.nextLine();
        System.out.print("Значение: ");
        String value = scanner.nextLine();

        for (int i = 0; i < books.getLength(); i++) {
            Element b = (Element) books.item(i);
            if (b.getElementsByTagName(field).item(0).getTextContent().equalsIgnoreCase(value)) {
                System.out.println("Найдено: " + b.getElementsByTagName("title").item(0).getTextContent());
            }
        }
    }

    static void deleteBook(Scanner scanner) throws Exception {
        Document doc = loadXML();
        NodeList books = doc.getElementsByTagName("book");
        System.out.print("Название книги для удаления: ");
        String target = scanner.nextLine();

        for (int i = 0; i < books.getLength(); i++) {
            Element b = (Element) books.item(i);
            String title = b.getElementsByTagName("title").item(0).getTextContent();
            if (title.equalsIgnoreCase(target)) {
                b.getParentNode().removeChild(b);
                saveXML(doc);
                System.out.println("Удалена книга: " + title);
                return;
            }
        }
        System.out.println("Книга не найдена.");
    }
}

