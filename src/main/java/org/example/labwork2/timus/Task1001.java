package org.example.labwork2.timus;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Task1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BigDecimal> numbers = new ArrayList<>();

        while (scanner.hasNext()) {
            if (scanner.hasNextLong()) {
                long num = scanner.nextLong();
                numbers.add(BigDecimal.valueOf(num));
            } else {
                scanner.next(); // Пропускаем некорректный ввод
            }
        }

        Collections.reverse(numbers);

        for (BigDecimal num : numbers) {
            BigDecimal sqrt = BigDecimal.valueOf(Math.sqrt(num.doubleValue()))
                    .setScale(4, RoundingMode.HALF_UP);
            System.out.println(sqrt);
        }
    }
}
