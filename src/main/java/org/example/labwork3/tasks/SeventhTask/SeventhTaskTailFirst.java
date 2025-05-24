package org.example.labwork3.tasks.SeventhTask;

public class SeventhTaskTailFirst {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        Node tail = head;

        for (int i = 2; i <= 5; i++) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }

        printList(head);
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}

