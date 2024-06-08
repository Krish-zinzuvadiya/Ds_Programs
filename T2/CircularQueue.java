import java.util.Scanner;

public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size :- ");
        int size = sc.nextInt();
        Queue1 q = new Queue1(size);
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Insert The Element.");
            System.out.println("2. Delete The Element.");
            System.out.println("3. Display The Queue.");
            System.out.println("4. Exit.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter The Element :- ");
                    int y = sc.nextInt();
                    q.insert(y);
                    break;
                case 2:
                    q.delete();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice.");
                    break;
            }
        }
    }
}

class Queue1 {
    int q1[];
    int f, r, size, y;
    Scanner sc = new Scanner(System.in);

    Queue1(int n) {
        q1 = new int[n];
        f = -1;
        r = -1;
        size = n;
    }

    void insert(int y) {
        if ((f == 0 && r == size - 1) || (f == r + 1)) {
            System.out.println("Queue is Overflow.");
        } else {
            if (r == size - 1) {
                r = 0;
            } else {
                r += 1;
            }
            q1[r] = y;
            System.out.println(y + " Inserted.");
            if (f == -1) {
                f = 0;
            }
        }
    }

    void delete() {
        if (f == -1) {
            System.out.println("Queue is Underflow.");
        } else {
            int y = q1[f];
            System.out.println(y + " Deleted.");
            if (f == r) {
                f = -1;
                r = -1;
            } else {
                if (f == size - 1) {
                    f = 0;
                } else {
                    f += 1;
                }
            }
        }
    }

    void display() {
        int i;
        if (f == -1) {
            System.out.println("Queue is Empty.");
        } else {
            System.out.println("--------------------");

            for (i = f; i != r; i = (i + 1) % size) {
                System.out.print(q1[i] + " || ");
            }
            System.out.println(q1[i]);
        }
        System.out.println("--------------------");
    }
}
