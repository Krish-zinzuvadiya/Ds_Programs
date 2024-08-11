// DoubleEnded Queue....
import java.util.Scanner;

public class DoubleEndedQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size :- ");
        int size = sc.nextInt();
        DoubleQueue q = new DoubleQueue(size);
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. For Insert An Element Using Front.");
            System.out.println("2. For Insert An Element Using Rear.");
            System.out.println("3. For Delete An Element Using Front.");
            System.out.println("4. For Delete An Element Using Rear.");
            System.out.println("5. For Get Front Element.");
            System.out.println("6. For Get Rear Element.");
            System.out.println("7. For Display The Queue.");
            System.out.println("8. For Exit...");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Enter Your Choice :- ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter An Element : ");
                    int i = sc.nextInt();
                    q.insertFront(i);
                    break;
                }
                case 2: {
                    System.out.print("Enter An Element : ");
                    int i1 = sc.nextInt();
                    q.insertRear(i1);
                    break;
                }
                case 3: {
                    q.deleteFront();
                    break;
                }
                case 4: {
                    q.deleteRear();
                    break;
                }
                case 5: {
                    q.getFront();
                    break;
                }
                case 6: {
                    q.getRear();
                    break;
                }
                case 7: {
                    q.display();
                    break;
                }
                case 8: {
                    System.out.println("Thank You!");
                    System.exit(0);
                }
                default: {
                    System.out.println("Enter Valid Number...");
                }
            }
        }
    }
}

class DoubleQueue {
    // This Is Additional For Creativity.
    public static final String RED_COLOR = "\u001B[31m";
    public static final String CYAN_COLOR = "\u001B[36m";
    public static final String RESET_COLOR = "\u001B[0m";

    int q1[];
    int f, r, size, y;
    Scanner sc = new Scanner(System.in);

    DoubleQueue(int n) {
        q1 = new int[n];
        size = n;
        f = -1;
        r = -1;
    }

    // --> Insert Front Element...
    void insertFront(int y) {
        if ((f == 0 && r == size - 1) || (f == r + 1)) {
            System.out.println("Queue Is Overflow.");
        } else {
            if (f == -1) {
                f = 0;
                r = 0;
            } else if (f == 0) {
                f = size - 1;
            } else {
                f--;
            }
            q1[f] = y;
            System.out.println(y + " Is Inserted.");
        }
    }

    // --> Insert Rear Element...
    void insertRear(int y) {
        if ((r == size - 1 && f == 0) || (f == r + 1)) {
            System.out.println("Queue Is Overflow.");
        } else {
            if (r == size - 1 && f > 0) {
                r = 0;
            } else {
                r += 1;
                if (f == -1) {
                    f = 0;
                }
            }
            q1[r] = y;
            System.out.println(y + " Is Inserted.");
        }
    }

    // --> Delete Front Element...
    void deleteFront() {
        if (f == -1) {
            System.out.println("Queue Is Underflow.");
        } else {
            int y = q1[f];
            if (f == r) {
                f = -1;
                r = -1;
            } else if (f == size - 1) {
                f = 0;
            } else {
                f += 1;
            }
            System.out.println(y + " Is Deleted.");
        }
    }

    // --> Delete Rear Element...
    void deleteRear() {
        if (f == -1) {
            System.out.println("Queue Is Underflow.");
        } else {
            if (f == r) {
                f = -1;
                r = -1;
            } else if (r == 0) {
                r = size - 1;
            } else {
                r--;
            }
            int y = q1[r];
            System.out.println(y + " Is Deleted.");
        }
    }

    // --> Get Front position Element...
    void getFront() {
        if (f != -1) {
            System.out.println("Front Element Is : " + q1[f]);
        } else {
            System.out.println(RED_COLOR + "Front Is -1." + RESET_COLOR);
        }
    }

    // --> Get Rear position Element...
    void getRear() {
        if (r != -1) {
            System.out.println("Rear Element Is : " + q1[r]);
        } else {
            System.out.println(RED_COLOR + "Rear Is -1." + RESET_COLOR);
        }
    }

    // --> Display The Whole Queue...
   void display() {
        if (f == -1) {
            System.out.println("Queue Is Empty.");
        } else {
            System.out.print("Queue Elements Are : ");
            int i = f;
            while (true) {
                System.out.print(q1[i] + " ");
                if (i == r) {
                    break;
                }
                if (i == size - 1) {
                    i = 0;
                } else {
                    i++;
                }
            }
            System.out.println();
        }
    }
}
