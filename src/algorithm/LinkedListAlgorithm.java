package algorithm;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
class LinkedList {
    private Node head;

    public void addData(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void deleteData(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println("Data is deleted: " + data);
            return;
        }

        Node previous = head;
        Node current = head;
        while (current.next != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (previous != current && current.next != null) {
            previous.next = current.next;
            System.out.println("Data is deleted: " + current.data);
        } else {
            System.out.println("No data to delete, " + data + " Not found.");
        }
    }

    public void display() {
        Node current = head;
        //System.out.println("All the linked list");
        while (current.next != null) {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.println("[" + current.data + "] -> None");
    }
    public boolean search(int data) {
        Node current = head;
        while (current.next != null && current.data != data) {
            current = current.next;
        }
        return current.data == data;
    }

}

public class LinkedListAlgorithm {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addData(1);
        list.addData(2);
        list.addData(3);
        list.addData(4);
        list.addData(5);

        list.display();
        list.deleteData(4);
        list.deleteData(1);
        list.display();
        System.out.println("Searched element is present: " + list.search(5));
    }
}