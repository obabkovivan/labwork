package org.example.labwork3.tasks;

import java.util.Scanner;

public class FirstTask {

    public static void example1(int x) {
        if (x >= 20) return;
        System.out.print(x + " ");
        example1(2 * x + 1);
    }

    public static void example2(int x) {
        if (x >= 20) return;
        example2(2 * x + 1);
        System.out.print(x + " ");
    }

    public static void example3(int x) {
        if (x >= 20) return;
        System.out.println("До вызова: " + x);
        example3(2 * x + 1);
        System.out.println("После вызова: " + x);
    }

    public static long example4_factorial(int n) {
        if (n <= 1) return 1;
        return example4_factorial(n - 1) * n;
    }

    public static int example5_fib(int n) {
        return example5_fib_withTree(n, "");
    }

    private static int example5_fib_withTree(int n, String indent) {
        System.out.println(indent + "fib(" + n + ")");
        if (n == 0) return 0;
        if (n == 1) return 1;
        int left = example5_fib_withTree(n - 1, indent + "  ");
        int right = example5_fib_withTree(n - 2, indent + "  ");
        return left + right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пример 1: Последовательность x = 2x+1 при 0 ≤ x < 20");
        System.out.print("Введите x: ");
        int x1 = scanner.nextInt();
        example1(x1);
        System.out.println("\n");

        System.out.println("Пример 2: Последовательность в обратном порядке");
        System.out.print("Введите x: ");
        int x2 = scanner.nextInt();
        example2(x2);
        System.out.println("\n");

        System.out.println("Пример 3: До и после рекурсивного вызова");
        System.out.print("Введите x: ");
        int x3 = scanner.nextInt();
        example3(x3);
        System.out.println();

        System.out.println("Пример 4: Факториал числа n");
        System.out.print("Введите n: ");
        int n = scanner.nextInt();
        System.out.println("Факториал " + n + " = " + example4_factorial(n));
        System.out.println();

        System.out.println("Пример 5: Число Фибоначчи с деревом вызовов");
        System.out.print("Введите номер числа Фибоначчи: ");
        int fibIndex = scanner.nextInt();
        int fibResult = example5_fib(fibIndex);
        System.out.println("F(" + fibIndex + ") = " + fibResult);
    }
}

