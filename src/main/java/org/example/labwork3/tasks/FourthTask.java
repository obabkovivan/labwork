package org.example.labwork3.tasks;

public class FourthTask {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        void print() {
            System.out.print(value + " ");
            if (next != null) {
                next.print();
            }
        }
    }
    public static void example1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node head = node1;
        while(head!= null){
            System.out.print(" " + head.value);
            head = head.next;
        }
    }

    public static void example2() {
        Node head = null;
        for (int i = 9; i >= 0; i--) {
            Node newNode = new Node(i);
            newNode.next = head;
            head = newNode;
        }

        Node ref = head;
        while(ref!=null){
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }

    public static void main(String[] args) {
        example1();
        System.out.println();
        example2();
    }
}

