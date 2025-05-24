package org.example.labwork6.tasks;

import java.time.LocalTime;

public class Task02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + " Timestamp: " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        });
        thread.start();
        thread.join();
    }
}

