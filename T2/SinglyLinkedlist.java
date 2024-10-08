import java.util.Scanner;

public class SinglyLinkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLL s = new SinglyLL();
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Insert First Element.");
            System.out.println("2. Insert Last Element.");
            System.out.println("3. Search The Element.");
            System.out.println("4. Insert Before Any Value.");
            System.out.println("5. Insert After Any Value.");
            System.out.println("6. Delete First Element.");
            System.out.println("7. Delete Last Element.");
            System.out.println("8. Delete Any Particular Value.");
            System.out.println("9. Display An Odd Number Of Elements.");
            System.out.println("10. Display An Even Number Of Elements.");
            System.out.println("11. Display Element Using Recursion.");
            System.out.println("12. Display Reverse Element Using Recursion.");
            System.out.println("13. Display An Sorted Element For New Element.");
            System.out.println("14.Delete Duplicate Values");
            System.out.println("15.Delete Only Even Values");
            System.out.println("16.Delete Only Odd Values");
            System.out.println("17.Delete Odd Positioned Nodes");
            System.out.println("18.Delete Even Positioned Nodes");
            System.out.println("19. Exit.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter The Element : ");
                    int y = sc.nextInt();
                    s.insertFirst(y);
                    s.display();
                    break;

                case 2:
                    System.out.print("Enter The Element : ");
                    int x = sc.nextInt();
                    s.insertLast(x);
                    s.display();
                    break;

                case 3:
                    System.out.print("Enter The Element : ");
                    int z = sc.nextInt();
                    s.search(z);
                    break;

                case 4:
                    System.out.print("Enter The Element From LinkList : ");
                    int val1 = sc.nextInt();
                    System.out.print("Enter The Element Before " + val1 + " : ");
                    int d1 = sc.nextInt();
                    s.insertBeforeValue(d1, val1);
                    s.display();
                    break;

                case 5:
                    System.out.print("Enter The Element From LinkList : ");
                    int val2 = sc.nextInt();
                    System.out.print("Enter The Element After " + val2 + " : ");
                    int d2 = sc.nextInt();
                    s.insertAfterValue(d2, val2);
                    s.display();
                    break;

                case 6:
                    s.deleteFirst();
                    s.display();
                    break;

                case 7:
                    s.deleteLast();
                    s.display();
                    break;

                case 8:
                    System.out.print("Enter Particular Element That You Want To Delete : ");
                    int val3 = sc.nextInt();
                    s.deleteParticularValue(val3);
                    s.display();
                    break;

                case 9:
                    s.displayOdd();
                    break;

                case 10:
                    s.displayEven();
                    break;

                case 11:
                    s.recursionDisplay(s.first);
                    break;

                case 12:
                    s.reverseDisplay(s.first);
                    System.out.println();
                    break;

                case 13:
                    System.out.print("Enter The New Element You Want To Sorted :- ");
                    int val4 = sc.nextInt();
                    s.sortedInsert(val4);
                    s.display();
                    break;

                case 14:
                    s.deleteDuplicates();
                    s.display();
                    break;

                case 15:
                    s.deleteEvenValues();
                    s.display();
                    break;

                case 16:
                    s.deleteOddValues();
                    s.display();
                    break;

                case 17:
                    s.deleteOddPositionedNodes();
                    s.display();
                    break;

                case 18:
                    s.deleteEvenPositionedNodes();
                    s.display();
                    break;

                case 19:
                    System.out.println("Thank You For Using Our Code...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice.");
                    System.out.println("Please Enter Valid (1-9) Choice...");
            }
        }
    }
}

class SinglyLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node first = null;

    void insertFirst(int d) {

        Node n = new Node(d);

        if (first == null) {
            first = n;
        } else {
            n.next = first;
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
            temp.next = n;
        }
    }

    void search(int val) {
        Node temp = first;
        int f = 0;
        int c = 0;
        while (temp != null) {
            c++;
            if (temp.data == val) {
                System.out.println(val + " Value is founded at --> " + c);
                f = 1;
                break;
            }
            temp = temp.next;
        }
        if (f == 0) {
            System.out.println(val + " Value is not found");
        }
    }

    void insertBeforeValue(int d, int val) {
        Node temp = first;
        int f = 0;
        int c = 0;
        while (temp != null) {
            c++;
            if (temp.data == val) {
                System.out.println(val + " Value is founded at --> " + c);
                f = 1;
                break;
            }
            temp = temp.next;
        }
        if (f == 0) {
            System.out.println(val + " Value is not found");
        } else {
            Node n = new Node(d);
            if (first.data == val) {
                n.next = first;
                first = n;
            } else {
                Node temp1 = first;
                while (temp1.next.data != val) {
                    temp1 = temp1.next;
                }
                n.next = temp1.next;
                temp1.next = n;
            }
        }
    }

    void insertAfterValue(int d, int val) {
        Node temp = first;
        int f = 0;
        int c = 0;
        while (temp != null) {
            c++;
            if (temp.data == val) {
                System.out.println(val + " Value is founded at --> " + c);
                f = 1;
                break;
            }
            temp = temp.next;
        }
        if (f == 0) {
            System.out.println(val + " Value is not found");
        } else {
            Node n = new Node(d);

            Node temp1 = first;
            while (temp1.data != val) {
                temp1 = temp1.next;
            }
            n.next = temp1.next;
            temp1.next = n;
        }
    }

    void deleteFirst() {
        if (first == null) {
            System.out.println("List is Empty.");
        } else {
            first = first.next;
        }
        System.out.println("First Node Deleted.");
    }

    void deleteLast() {
        if (first == null) {
            System.out.println("List is Empty.");
        } else if (first.next == null) {
            first = null;
        } else {
            Node temp = first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        System.out.println("Last Node Deleted.");
    }

    void deleteParticularValue(int val) {
        Node temp = first;
        int f = 0;
        int c = 0;
        while (temp != null) {
            c++;
            if (temp.data == val) {
                System.out.println(val + " Value is founded at --> " + c);
                f = 1;
                break;
            }
            temp = temp.next;
        }
        if (f == 0) {
            System.out.println(val + " Value is not found");
        } else {
            if (first.data == val) {
                first = first.next;
            } else {
                Node temp1 = first;
                while (temp1.next.data != val) {
                    temp1 = temp1.next;
                }
                Node a = temp1.next;
                temp1.next = a.next;
                a.next = null;
            }
        }
    }

    void display() {
        Node temp = first;
        if (first == null) {
            System.out.println("List is Empty.");
        } else {

            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    void displayOdd() {
        int count = 0;
        Node temp = first;
        if (first == null) {
            System.out.println("List is Empty.");
        } else {
            while (temp != null) {
                count++;
                if (count % 2 != 0) {
                    System.out.print(temp.data + " --> ");
                }
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    void displayEven() {
        int count = 0;
        Node temp = first;
        if (first == null) {
            System.out.println("List is Empty.");
        } else {
            while (temp != null) {
                count++;
                if (count % 2 == 0) { // Check if the position is even
                    System.out.print(temp.data + " --> ");
                }
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    void recursionDisplay(Node temp) {
        if (temp != null) {
            System.out.print(temp.data + " --> ");
            recursionDisplay(temp.next);
        } else {
            System.out.println("null");
        }
    }

    void reverseDisplay(Node temp) {
        if (temp != null) {
            reverseDisplay(temp.next);
            System.out.print(temp.data + " <-- ");
        } else {
            System.out.print("null <-- ");
            return;
        }
    }

    void sortedInsert(int d) {
        Node n = new Node(d);
        if (first == null || first.data >= n.data) {
            n.next = first;
            first = n;
        } else {
            Node temp = first;
            while (temp.next != null && temp.next.data < n.data) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }
    }

    void deleteDuplicates() {
        Node temp = first;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    void deleteEvenValues() {
        if (first == null) {
            return;
        }

        if (first.data % 2 == 0) {
            first = first.next;
        }

        Node temp = first;
        while (temp != null && temp.next != null) {
            if (temp.next.data % 2 == 0) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    void deleteOddValues() {
        if (first == null) {
            return;
        }

        if (first.data % 2 != 0) {
            first = first.next;
        }

        Node temp = first;
        while (temp != null && temp.next != null) {
            if (temp.next.data % 2 != 0) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    void deleteOddPositionedNodes() {
        if (first == null) {
            return;
        }

        Node temp = first;
        int position = 1;

        while (temp != null && temp.next != null) {
            if (position % 2 != 0) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
            position++;
        }
    }

    void deleteEvenPositionedNodes() {
        if (first == null) {
            return;
        }

        Node temp = first;

        if (temp.next != null) {
            Node next = temp.next;
            temp.next = next.next;
        }

        int position = 2;
        temp = first;

        while (temp != null && temp.next != null) {
            if (position % 2 == 0) {
                Node next = temp.next;
                temp.next = next.next;
            } else {
                temp = temp.next;
            }
            position++;
        }
    }
}
