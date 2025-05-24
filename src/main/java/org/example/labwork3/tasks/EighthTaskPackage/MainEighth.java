package org.example.labwork3.tasks.EighthTaskPackage;

public class MainEighth {
    public static void main(String[] args) {
        EighthTask list = new EighthTask();

        list.createHeadRec(new int[]{1, 2, 3});
        System.out.println("HeadRec: " + list.toStringRec());

        list.createTailRec(new int[]{4, 5, 6});
        System.out.println("TailRec: " + list.toStringRec());

        list.addFirst(10);
        list.addLast(99);
        list.insert(2, 55);
        System.out.println("После вставок: " + list);

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        System.out.println("После удалений: " + list);
    }
}
