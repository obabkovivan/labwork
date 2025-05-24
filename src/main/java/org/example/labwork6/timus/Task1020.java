package org.example.labwork6.timus;

import java.util.Scanner;

public class Task1020 {
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x; this.y = y;
        }

        double distanceTo(Point other) {
            double dx = x - other.x;
            double dy = y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double R = scanner.nextDouble();

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        double length = 0;
        for (int i = 0; i < N; i++) {
            Point a = points[i];
            Point b = points[(i + 1) % N];
            length += a.distanceTo(b);
        }

        length += 2 * Math.PI * R;

        System.out.printf("%.2f\n", length);
    }
}
