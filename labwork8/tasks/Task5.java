package org.example.labwork8.tasks;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class Task5 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("products.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Товары");
            if (sheet == null) {
                System.err.println("Лист 'Товары' не найден.");
                return;
            }

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            System.err.println("Проверьте, существует ли файл и корректен ли формат.");
        }
    }
}

