import java.util.Scanner;

public class QueueUsingLinklist {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Queue q = new Queue();
        while(true){
            System.out.println("1.For Enqueue");
            System.out.println("2.For Dequeue");
            System.out.println("3.For Exit");
            System.out.print("Enter Your Choice :- ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter your value for enqueue :- ");
                    int n1 = sc.nextInt();
                    q.enqueue(n1);
                    q.display();
                    break;

                case 2:
                    q.dequeue();
                    q.display();
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
class Queue{
    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }
    Node front = null;
    Node rear = null;

    void enqueue(int d){
        Node n = new Node(d);
        if(front == null){
            front = n;
            rear = n;
        }
        else{
            rear.next = n;
            rear = n;
        }
    }

    void dequeue(){
        if(front == null){
            System.out.println("Queue is Empty.");
        }
        else{
            front = front.next;
        }
    }

    void display(){
        Node temp = front;
        if(front == null){
            System.out.println("List is Empty.");
        } else {
            System.out.println("----------------------");
            while(temp!= null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
            System.out.println("----------------------");
        }
    }
}
    