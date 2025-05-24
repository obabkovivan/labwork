package org.example.labwork3.tasks;

import java.util.*;


public class CollectionPerformanceTest {

    private static final int ELEMENTS = 4_000_000;
    private static final int TEST_VALUE = -1;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        // Заполняем коллекции
        for (int i = 0; i < ELEMENTS; i++) {
            arrayList.add(i);
            treeSet.add(i);
            linkedHashMap.put(i, i);
        }

        System.out.println("----- ДОБАВЛЕНИЕ -----");
        addToBeginning(arrayList, "ArrayList");
        addToBeginning(treeSet, "TreeSet");
        addToBeginning(linkedHashMap, "LinkedHashMap");

        addToEnd(arrayList, "ArrayList");
        addToEnd(treeSet, "TreeSet");
        addToEnd(linkedHashMap, "LinkedHashMap");

        addToMiddle(arrayList, "ArrayList");
        addToMiddle(treeSet, "TreeSet");
        addToMiddle(linkedHashMap, "LinkedHashMap");

        System.out.println("\n----- УДАЛЕНИЕ -----");
        removeFromBeginning(arrayList, "ArrayList");
        removeFromBeginning(treeSet, "TreeSet");
        removeFromBeginning(linkedHashMap, "LinkedHashMap");

        removeFromEnd(arrayList, "ArrayList");
        removeFromEnd(treeSet, "TreeSet");
        removeFromEnd(linkedHashMap, "LinkedHashMap");

        removeFromMiddle(arrayList, "ArrayList");
        removeFromMiddle(treeSet, "TreeSet");
        removeFromMiddle(linkedHashMap, "LinkedHashMap");

        System.out.println("\n----- ПОЛУЧЕНИЕ -----");
        getByIndex(arrayList, "ArrayList");
        getByIndex(treeSet, "TreeSet");
        getByIndex(linkedHashMap, "LinkedHashMap");
    }

    // === ДОБАВЛЕНИЕ ===
    private static void addToBeginning(List<Integer> list, String name) {
        long start = System.nanoTime();
        list.add(0, TEST_VALUE);
        long end = System.nanoTime();
        System.out.println(name + " - добавление в начало: " + (end - start) + " нс");
    }

    private static void addToBeginning(Set<Integer> set, String name) {
        long start = System.nanoTime();
        set.add(TEST_VALUE);
        long end = System.nanoTime();
        System.out.println(name + " - добавление (позиция не поддерживается): " + (end - start) + " нс");
    }

    private static void addToBeginning(Map<Integer, Integer> map, String name) {
        long start = System.nanoTime();
        map.put(TEST_VALUE, TEST_VALUE);
        long end = System.nanoTime();
        System.out.println(name + " - добавление (позиция не поддерживается): " + (end - start) + " нс");
    }

    private static void addToEnd(List<Integer> list, String name) {
        long start = System.nanoTime();
        list.add(TEST_VALUE);
        long end = System.nanoTime();
        System.out.println(name + " - добавление в конец: " + (end - start) + " нс");
    }

    private static void addToEnd(Set<Integer> set, String name) {
        addToBeginning(set, name);
    }

    private static void addToEnd(Map<Integer, Integer> map, String name) {
        addToBeginning(map, name);
    }

    private static void addToMiddle(List<Integer> list, String name) {
        int middle = list.size() / 2;
        long start = System.nanoTime();
        list.add(middle, TEST_VALUE);
        long end = System.nanoTime();
        System.out.println(name + " - добавление в середину: " + (end - start) + " нс");
    }

    private static void addToMiddle(Set<Integer> set, String name) {
        System.out.println(name + " - добавление в середину не поддерживается");
    }

    private static void addToMiddle(Map<Integer, Integer> map, String name) {
        System.out.println(name + " - добавление в середину не поддерживается");
    }

    // === УДАЛЕНИЕ ===
    private static void removeFromBeginning(List<Integer> list, String name) {
        long start = System.nanoTime();
        list.remove(0);
        long end = System.nanoTime();
        System.out.println(name + " - удаление из начала: " + (end - start) + " нс");
    }

    private static void removeFromBeginning(Set<Integer> set, String name) {
        int first = set.iterator().next();
        long start = System.nanoTime();
        set.remove(first);
        long end = System.nanoTime();
        System.out.println(name + " - удаление первого элемента: " + (end - start) + " нс");
    }

    private static void removeFromBeginning(Map<Integer, Integer> map, String name) {
        int first = map.keySet().iterator().next();
        long start = System.nanoTime();
        map.remove(first);
        long end = System.nanoTime();
        System.out.println(name + " - удаление первого элемента: " + (end - start) + " нс");
    }

    private static void removeFromEnd(List<Integer> list, String name) {
        long start = System.nanoTime();
        list.remove(list.size() - 1);
        long end = System.nanoTime();
        System.out.println(name + " - удаление из конца: " + (end - start) + " нс");
    }

    private static void removeFromEnd(Set<Integer> set, String name) {
        int last = -1;
        for (int val : set) last = val;
        long start = System.nanoTime();
        set.remove(last);
        long end = System.nanoTime();
        System.out.println(name + " - удаление последнего элемента: " + (end - start) + " нс");
    }

    private static void removeFromEnd(Map<Integer, Integer> map, String name) {
        int last = -1;
        for (int key : map.keySet()) last = key;
        long start = System.nanoTime();
        map.remove(last);
        long end = System.nanoTime();
        System.out.println(name + " - удаление последнего элемента: " + (end - start) + " нс");
    }

    private static void removeFromMiddle(List<Integer> list, String name) {
        int middle = list.size() / 2;
        long start = System.nanoTime();
        list.remove(middle);
        long end = System.nanoTime();
        System.out.println(name + " - удаление из середины: " + (end - start) + " нс");
    }

    private static void removeFromMiddle(Set<Integer> set, String name) {
        int i = 0, target = 0;
        for (int val : set) {
            if (i++ == set.size() / 2) {
                target = val;
                break;
            }
        }
        long start = System.nanoTime();
        set.remove(target);
        long end = System.nanoTime();
        System.out.println(name + " - удаление элемента из середины (по значению): " + (end - start) + " нс");
    }

    private static void removeFromMiddle(Map<Integer, Integer> map, String name) {
        int i = 0, target = 0;
        for (int key : map.keySet()) {
            if (i++ == map.size() / 2) {
                target = key;
                break;
            }
        }
        long start = System.nanoTime();
        map.remove(target);
        long end = System.nanoTime();
        System.out.println(name + " - удаление ключа из середины (по значению): " + (end - start) + " нс");
    }

    // === ПОЛУЧЕНИЕ ЭЛЕМЕНТА ===
    private static void getByIndex(List<Integer> list, String name) {
        long start = System.nanoTime();
        int val = list.get(list.size() / 2);
        long end = System.nanoTime();
        System.out.println(name + " - получение по индексу: " + (end - start) + " нс");
    }

    private static void getByIndex(Set<Integer> set, String name) {
        int i = 0, target = 0;
        for (int val : set) {
            if (i++ == set.size() / 2) {
                target = val;
                break;
            }
        }
        long start = System.nanoTime();
        boolean contains = set.contains(target);
        long end = System.nanoTime();
        System.out.println(name + " - contains для среднего значения: " + (end - start) + " нс");
    }

    private static void getByIndex(Map<Integer, Integer> map, String name) {
        int i = 0, target = 0;
        for (int key : map.keySet()) {
            if (i++ == map.size() / 2) {
                target = key;
                break;
            }
        }
        long start = System.nanoTime();
        int val = map.get(target);
        long end = System.nanoTime();
        System.out.println(name + " - получение значения по ключу: " + (end - start) + " нс");
    }
}

