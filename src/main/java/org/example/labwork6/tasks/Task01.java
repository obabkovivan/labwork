package org.example.labwork6.tasks;

import java.time.LocalTime;

public class Task01 {
    public static void main(String[] args) {
        Runnable printTime = () -> {
            long end = System.currentTimeMillis() + 10_000;
            while (System.currentTimeMillis() < end) {
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        };
        new Thread(printTime, "Thread-1").start();
        new Thread(printTime, "Thread-2").start();
    }
}

