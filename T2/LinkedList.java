//Write a Java Method to Delete all the elements in Singly Linked List using recursion//
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void deleteList() {
        deleteListRecursive(head);
        head = null; // Reset the head to null after deleting all nodes
    }

    private void deleteListRecursive(Node node) {
        if (node == null)
            return;

        deleteListRecursive(node.next);
        node.next = null; // Remove the reference to the next node
    }

    public void displayList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Create the linked list
        linkedList.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);

        linkedList.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        System.out.println("Original Linked List:");
        linkedList.displayList();

        linkedList.deleteList();

        System.out.println("Linked List after deletion:");
        linkedList.displayList();
    }
}