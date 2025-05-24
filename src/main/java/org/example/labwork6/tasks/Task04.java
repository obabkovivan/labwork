package org.example.labwork6.tasks;

public class Task04 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int num = i;
            new Thread(() -> System.out.println("Thread #" + num)).start();
        }
    }
}

