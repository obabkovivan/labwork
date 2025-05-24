package org.example.labwork3.tasks.EighthTaskPackage;


public class EighthTask {
    private Node head;

    // ---------- (а) МЕТОДЫ С ЦИКЛАМИ ----------

    public void createHead(int[] values) {
        head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            Node newNode = new Node(values[i]);
            newNode.next = head;
            head = newNode;
        }
    }
    public void createTail(int[] values) {
        head = null;
        Node tail = null;
        for (int value : values) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null) return;
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    // ---------- (б) РЕКУРСИВНЫЕ МЕТОДЫ ----------

    public void createHeadRec(int[] values) {
        head = createHeadRecHelper(values, values.length - 1);
    }

    private Node createHeadRecHelper(int[] values, int index) {
        if (index < 0) return null;
        Node newNode = new Node(values[index]);
        newNode.next = createHeadRecHelper(values, index - 1);
        return newNode;
    }

    public void createTailRec(int[] values) {
        head = null;
        createTailRecHelper(values, 0);
    }

    private void createTailRecHelper(int[] values, int index) {
        if (index >= values.length) return;
        addLast(values[index]);
        createTailRecHelper(values, index + 1);
    }

    public String toStringRec() {
        return toStringRecHelper(head).trim();
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        return node.value + " " + toStringRecHelper(node.next);
    }
}

