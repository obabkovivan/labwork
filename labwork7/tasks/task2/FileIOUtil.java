package org.example.labwork7.tasks.task2;

import java.io.*;

public class FileIOUtil {

    public static void writeBytes(String path, String data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(data.getBytes());
        }
    }

    public static void readBytes(String path) throws IOException {
        try (FileInputStream fis = new FileInputStream(path)) {
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
        }
    }

    public static void writeText(String path, String data) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(data);
        }
    }

    public static void readText(String path) throws IOException {
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }

    public static void writeBuffered(String path, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
        }
    }

    public static void readBuffered(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void writeWithEncoding(String path, String data, String encoding) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path), encoding)) {
            osw.write(data);
        }
    }

    public static void readWithEncoding(String path, String encoding) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void writeWithPrintWriter(String path, String data, String encoding) throws IOException {
        try (PrintWriter writer = new PrintWriter(path, encoding)) {
            writer.println(data);
        }
    }

    public static void readBufferedLines(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static boolean deleteFile(String path) {
        return new File(path).delete();
    }

    public static void findLinesWithWord(String path, String word) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.println(line);
                }
            }
        }
    }

    public static int writeAndCountChars(String path, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
            return data.length();
        }
    }

    public static void serializeObject(String path, Object obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
        }
    }

    public static Object deserializeObject(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        }
    }

    public static int countLines(String path) throws IOException {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.readLine() != null) {
                lines++;
            }
        }
        return lines;
    }

    public static void copyFile(String sourcePath, String destPath) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destPath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static long getFileSize(String path) {
        File file = new File(path);
        return file.exists() ? file.length() : -1;
    }

    public static void findLinesWithWord1(String path, String word) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.println(line);
                }
            }
        }
    }

    public static int writeAndCountChars1(String path, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
            return data.length();
        }
    }


}
