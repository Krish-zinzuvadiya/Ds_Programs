import java.util.Scanner;

class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL ob = new DLL();
        int choice;
        while (true) {
            System.out.println("1. Insert At First.");
            System.out.println("2. Insert At Last.");
            System.out.println("3. Insert Before Any Value.");
            System.out.println("4. Insert After Any Value.");
            System.out.println("5. Delete First Element.");
            System.out.println("6. Delete Last Element.");
            System.out.println("7. Delete Particular Element.");
            System.out.println("8. Display Reverse List.");
            System.out.println("9.Ordered List.");
            System.out.println("10.Exit.");

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
                    System.out.print("Already Presented Value in Linkedlist : ");
                    int val = sc.nextInt();
                    System.out.print("Enter Value You Want to be instert before...: ");
                    int d1 = sc.nextInt();
                    ob.insertBeforeValue(d1, val);
                    ob.display();
                    break;
                case 4:
                    System.out.print("Already Presented Value in Linkedlist : ");
                    int val1 = sc.nextInt();
                    System.out.print("Enter Value You Want to be instert after...: ");
                    int d2 = sc.nextInt();
                    ob.insertAfterValue(d2, val1);
                    ob.display();
                    break;
                case 5:
                    ob.deleteFirst();
                    ob.display();
                    break;
                case 6:
                    ob.deleteLast();
                    ob.display();
                    break;

                case 7:
                    System.out.print("Enter the value to be deleted: ");
                    int d3 = sc.nextInt();
                    ob.deleteValue(d3);
                    ob.display();
                    break;

                case 8:
                    ob.revDisplay();
                    break;

                case 9:
                    System.out.print("Enter The Value : ");
                    int val3 = sc.nextInt();
                    ob.orderSet(val3);
                    ob.display();
                    break;

                case 10:
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

    void insertBeforeValue(int d, int val) {
        int f = 0;
        Node dummy = first;
        while (dummy != null) {
            if (dummy.data == val) {
                f = 1;
            }
            dummy = dummy.next;
        }
        if (f == 0) {
            System.out.println("Value Is Not Found");
        } else {
            Node n = new Node(d);
            if (first.data == val) {
                n.next = first;
                first.prev = n;
                first = n;
            } else {
                Node temp = first;
                while (temp.data != val) {
                    temp = temp.next;
                }
                n.next = temp;
                n.prev = temp.prev;
                temp.prev.next = n;
                temp.prev = n;
            }
        }
    }

    void insertAfterValue(int d, int val) {
        int f = 0;
        Node dummy = first;
        while (dummy != null) {
            if (dummy.data == val) {
                f = 1;
            }
            dummy = dummy.next;
        }
        if (f == 0) {
            System.out.println("Value Is Not Found");
        } else {
            Node n = new Node(d);
            Node temp = first;
            while (temp.data != val) {
                temp = temp.next;
            }
            if (temp.next != null) {
                n.next = temp.next;
                n.prev = temp;
                temp.next.prev = n;
                temp.next = n;
            } else {
                temp.next = n;
                n.prev = temp;
            }
        }
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

    void deleteValue(int val) {
        int f = 0;
        Node dummy = first;
        while (dummy != null) {
            if (dummy.data == val) {
                f = 1;
            }
            dummy = dummy.next;
        }
        if (f == 0) {
            System.out.println("Value Is Not Found");
        } else {
            if (first.data == val) {
                Node del = first;
                if (first.next != null) {
                    first = first.next;
                    first.prev = null;
                } else {
                    first = null;
                }
                del.next = null;
                System.out.println(del.data + " Is Deleted.");
            } else {
                Node temp = first;
                while (temp.data != val) {
                    temp = temp.next;
                }
                if (temp.next != null) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                } else {
                    temp.prev.next = null;
                    temp.prev = null;
                    System.out.println(temp.data + " Is Deleted.");
                }
            }
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

    void orderSet(int d) {
        Node n = new Node(d);
        if (first == null) {
            first = n;
        } else if (first.data >= n.data) {
            n.next = first;
            first.prev = n;
            first = n;
        } else {
            Node temp = first;
            while (temp.next != null && temp.data < n.data) {
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = n;
                n.prev = temp;
            } else {
                n.next = temp.next;
                n.prev = temp;
                temp.next.prev = n;
                temp.next = n;
            }
        }
    }
}
