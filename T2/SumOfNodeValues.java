import java.util.Scanner;
class SingyLinkedList
{
    Scanner sc = new Scanner(System.in);
    class Node
    {
        int data;
        Node next;
        Node(){
            System.out.println("Insert the data part of a new node - ");
            data = sc.nextInt();
            next = null;
        }
    }

    Node head = null;

    void insertatLast()
    {
        Node newNode = new Node();
        if(head == null){
            head = newNode;
        } else{
            Node tail = head;
            while(tail.next != null)
            {
                tail = tail.next;
            }
            tail.next = newNode;
        }
    }

    void display(){
        if(head == null)
        {
            System.out.println("LL is Empty");
        }
        else
        {
            Node temp = head;
            while(temp != null)
            {
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.println("null");
            
        }
    }

    int findSum()
    {
        int add =0;
        if(head == null)
        {
            return 0;
        }
        else
        {
            Node temp = head;
            while(temp != null)
            {
                add += temp.data;
                temp = temp.next;
            }
            return add;
        }
    }
}

class SumOfNodeValues
{
    public static void main(String args[]) 
    {
        SingyLinkedList  s = new SingyLinkedList();
        s.insertatLast();
        s.insertatLast();
        s.insertatLast();
        System.out.print("SinglyLinkedList display method without any args - ");
        s.display();
        int sum = s.findSum();    
        System.out.println("Sum of nodes values of linkedlist is - " + sum);
    }
}