package org.example.labwork3.tasks.SeventhTask;

public class SeventhTaskHeadFirst {
    public static void main(String[] args) {
        Node head = null;

        for (int i = 5; i >= 1; i--) {
            Node newNode = new Node(i, null);
            newNode.next = head;
            head = newNode;
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

