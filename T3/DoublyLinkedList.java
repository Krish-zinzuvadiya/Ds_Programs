import java.util.Scanner;

class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL ob = new DLL();
        int choice;
        while (true) {
            System.out.println("1. Insert At First.");
            System.out.println("2. Insert At Last.");
            System.out.println("3. Delete First Element.");
            System.out.println("4. Delete Last Element.");
            System.out.println("5. Display Reverse List.");
            System.out.println("6.Exit.");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to be inserted: ");
                    int data = sc.nextInt();
                    ob.insertFirst(data);
                    ob.display();
                    break;
                case 2:
                    System.out.print("Enter the data to be inserted: ");
                    int d = sc.nextInt();
                    ob.insertLast(d);
                    ob.display();
                    break;
                case 3:
                    ob.deleteFirst();
                    ob.display();
                    break;
                case 4:
                    ob.deleteLast();
                    ob.display();
                    break;

                case 5:
                    ob.revDisplay();
                    break;
                case 6:
                    System.out.println("Thank You!!!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!!!");
            }
        }
    }
}

class DLL {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    Node first = null;
    Node prev = null;

    void insertFirst(int d) {
        Node n = new Node(d);
        if (first == null) {
            first = n;
        } else {
            n.next = first;
            first.prev = n;
            first = n;
        }
        System.out.println(d + " Is Inserted.");
    }

    void insertLast(int d) {
        Node n = new Node(d);
        if (first == null) {
            first = n;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            n.prev = temp;
            temp.next = n;
        }
        System.out.println(d + " Is Inserted.");
    }

    void display() {
        if (first == null) {
            System.out.println("LinkList is empty!!!");
        } else {
            Node temp = first;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    void deleteFirst() {
        if (first == null) {
            System.out.println("LinkList is empty!!!");
        } else if (first.next == null && first.prev == null) {
            System.out.println(first.data + " Is Deleted.");
            first = null;
        } else {
            Node del = first;
            first = first.next;
            first.prev = null;
            del.next = null;
            System.out.println(del.data + " Is Deleted.");
        }
    }

    void deleteLast() {
        if (first == null) {
            System.out.println("LinkList is empty!!!");
        } else if (first.next == null && first.prev == null) {
            System.out.println(first.data + " Is Deleted.");
            first = null;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;
            System.out.println(temp.data + " Is Deleted.");
        }
    }

    void revDisplay() {
        if (first == null) {
            System.out.println("LinkList is empty!!!");
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.prev;
            }
            System.out.println();
        }
    }
}