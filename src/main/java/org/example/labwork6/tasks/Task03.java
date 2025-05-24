package org.example.labwork6.tasks;

public class Task03 {
    public static void main(String[] args) {
        Runnable even = () -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
        };

        Runnable odd = () -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Odd: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
        };

        new Thread(even).start();
        new Thread(odd).start();
    }
}

