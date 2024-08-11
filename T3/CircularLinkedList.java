import java.util.Scanner;

class CircularLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLL ob = new CLL();
        int choice;
        while (true) {
            System.out.println("1. Insert At First.");
            System.out.println("2. Insert At Last.");
            System.out.println("3. Insert At Before Any Value.");
            System.out.println("4. Insert At After Any Value.");
            System.out.println("5. Delete First Element.");
            System.out.println("6. Delete Last Element.");
            System.out.println("7. Delete Particular Element.");
            System.out.println("8.Sum Of All Elements.");
            System.out.println("9.Print Maximum Number.");
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
                    System.out.print("Enter Value You Want to be instert After...: ");
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
                    System.out.print("Enter the Value is already present in the list: ");
                    int data5 = sc.nextInt();
                    ob.deleteParticularValue(data5);
                    ob.display();
                    break;
                case 8:
                    ob.sum();
                    break;
                case 9:
                    ob.printMaximumNumber();
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

class CLL {
    class Node {
        Node next;
        int data;

        Node(int d) {
            next = null;
            data = d;
        }
    }

    Node first = null;

    void insertFirst(int d) {
        Node n = new Node(d);
        if (first == null) {
            first = n;
            n.next = n;
        } else {
            n.next = first;
            Node temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            temp.next = n;
            first = n;
        }
        System.out.println(d + " Is Inserted.");
    }

    void insertLast(int d) {
        Node n = new Node(d);
        if (first == null) {
            first = n;
            n.next = n;
        } else {
            n.next = first;
            Node temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            temp.next = n;
            n.next = first;
        }
        System.out.println(d + " Is Inserted.");
    }

    void display() {
        if (first == null) {
            System.out.println("LinkList is empty !!!");
        } else {
            Node temp = first;
            while (temp.next != first) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }

    void deleteFirst() {
        if (first == null) {
            System.out.println("LinkList is empty!!!");
        } else if (first.next == null) {
            first = null;
        } else {
            Node del = first;
            Node temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            temp.next = first.next;
            first = first.next;
            del.next = null;
        }
        System.out.println("Deleted Successfully!!!");
    }

    void deleteLast() {
        if (first == null) {
            System.out.println("LinkList is empty!!!");
        } else if (first.next == first) {
            first = null;
        } else {
            Node temp = first;
            while (temp.next.next != first) {
                temp = temp.next;
            }
            Node del = temp.next;
            temp.next = first;
            del.next = null;
        }
        System.out.println("Deleted Successfully!!!");
    }

   void insertBeforeValue(int d, int val) {
        int f = 0;
        Node dummy = first;

        do {
            if (dummy.data == val) {
                f = 1;
                break;
            }
            dummy = dummy.next;
        } while (dummy != first);
        if (f == 0) {
            System.out.println("Value Not Found !");
        } else {
            Node n = new Node(d);
            if (dummy == first) {
                Node temp = first;
                while (temp.next != first) {
                    temp = temp.next;
                }
                n.next = first;
                temp.next = n;
                first = n;
            } else {
                Node temp = first;
                while (temp.next != dummy) {
                    temp = temp.next;
                }
                n.next = temp.next;
                temp.next = n;
            }
        }
    }

    void insertAfterValue(int d, int val) {
        int found = 0;
        Node dummy = first;
        do {
            if (dummy.data == val) {
                found = 1;
                break;
            }
            dummy = dummy.next;
        } while (dummy != first);

        if (found == 0) {
            System.out.println("Value Not Found!!!");
        } else {
            Node n = new Node(d);
            if (dummy.next == first) {
                n.next = first;
                dummy.next = n;
            } else {
                n.next = dummy.next;
                dummy.next = n;
            }
        }
    }

    void deleteParticularValue(int val) {
        int f = 0;
        Node dummy = first;

        do {
            if (dummy.data == val) {
                f = 1;
            }
            dummy = dummy.next;
        } while (dummy != first);
        if (f == 0) {
            System.out.println("Value Not Found!!!");
        } else {
            if (first.data == val && first.next == first) {
                first = null;
            } else if (first.data == val && first.next != first) {
                Node del = first;
                Node temp = first;
                while (temp.next != first) {
                    temp = temp.next;
                }
                temp.next = first.next;
                first = first.next;
                del.next = null;
            } else {
                Node temp = first;
                while (temp.next.data != val) {
                    temp = temp.next;
                }
                Node del = temp.next;
                temp.next = temp.next.next;
                del.next = null;
            }
        }
    }

    void sum() {
        Node temp = first;
        int sum = 0;
        while (temp.next != first) {
            sum = sum + temp.data;
            temp = temp.next;
        }
        sum = sum + temp.data;
        System.out.println("Sum of the elements of the link list is : " + sum);
    }

    void printMaximumNumber() {
        if (first == null) {
            System.out.println("LinkList is empty!!!");
            return;
        }
        Node temp = first;
        int max = first.data;
        do {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        } while (temp != first);
        System.out.println("Maximum Value Is : " + max);
    }
}

void insertOrdered(int d) {
        Node n = new Node(d);
        if (first == null) {
            first = n;
            n.next = n;
        } else if (d < first.data) {
            Node temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            temp.next = n;
            n.next = first;
            first = n;
        } else {
            Node temp = first;
            while (temp.next != first && temp.next.data < d) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }
        System.out.println(d + " Is Inserted.");
    }
