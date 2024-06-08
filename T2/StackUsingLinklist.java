import java.util.Scanner;

public class StackUsingLinklist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        while (true) {
            System.out.println("1.PUSH");
            System.out.println("2.POP");
            System.out.println("3.EXIT");

            System.out.print("Enter Your Choice :- ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your value for push :- ");
                    int n1 = sc.nextInt();
                    s.push(n1);
                    s.display();
                    break;

                case 2:
                    s.pop();
                    s.display();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice.");
                    break;
            }
        }
    }
}

class Stack {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node top = null;

    void push(int d) {
        Node n = new Node(d);
        if (top == null) {
            top = n;
        } else {
            n.next = top;
            top = n;
        }
    }

    void pop() {
        if (top == null) {
            System.out.println("Stack Is Empty.");
        } else {
            top = top.next;
        }
    }

    void display() {
        Node temp = top;
        if (top == null) {
            System.out.println("List is Empty.");
        } else {

            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}