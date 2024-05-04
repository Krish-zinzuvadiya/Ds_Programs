import java.util.Scanner;

public class SinglyLinkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLL s = new SinglyLL();
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Insert First Element.");
            System.out.println("2. Insert Last Element.");
            System.out.println("3. Delete First Element.");
            System.out.println("4. Delete Last Element.");
           // System.out.println("5. Display.");
            System.out.println("5. Exit.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();
            switch(choice){
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
                    s.deleteFirst();
                    s.display();
                    break;
                case 4:
                    s.deleteLast();
                    s.display();
                    break;
                case 5: 
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}

class SinglyLL {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node first = null;

    void insertFirst(int d){

        Node n = new Node(d);

        if(first == null){
            first = n;
        } else {
            n.next = first;
            first = n;
        }
        System.out.println(d+" Is Inserted.");
    }

    void insertLast(int d){
        Node n = new Node(d);
        if(first == null){
            first = n;
        } else {
            Node temp = first;
            while(temp.next!= null){
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    void deleteFirst(){
        if(first == null){
            System.out.println("List is Empty.");
        } else {
            first = first.next;
        }
        System.out.println("First Node Deleted.");
    }

    void deleteLast(){
        if(first == null){
            System.out.println("List is Empty.");
        } else if(first.next == null){
            first = null;
        } else {
            Node temp = first;
            while(temp.next.next!= null){
                temp = temp.next;
            }
            temp.next = null;
        }
        System.out.println("Last Node Deleted.");
    }

    void display(){
        Node temp = first;
        if(first == null){
            System.out.println("List is Empty.");
        } else {

            while(temp!= null){
                System.out.print(temp.data+" --> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}
