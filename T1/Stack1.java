
import java.util.*;

class Stack1 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("enter the value of arrays : ");
    int n = sc.nextInt();
    Stack ob = new Stack(n);

    while(true){
        System.out.println("1.PUSH");
        System.out.println("2.POP");
        System.out.println("3.PEEP");
        System.out.println("4.CHANGE");
        System.out.println("5.EXIT");

        System.out.print("Enter Your Choice.: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1: {
                System.out.print("Enter your value for push.: ");
                int n1 = sc.nextInt();
                ob.push(n1);
                ob.display();
                break;
            }
            case 2: {
                ob.pop();
                ob.display();
                break;
            }
            case 3: {
                ob.peep();
                ob.display();
                break;
            }
            case 4: {
                ob.change();
                ob.display();
                break;
            }
            case 5: {
                System.exit(0);
            }
            }
        }
    }
}
class Stack {
    int s[];
    int size,x,top;
    Scanner sc = new Scanner(System.in);
    Stack(int n){
        s = new int[n];
        top = -1;
        size = n;
    }
    // for PUSH Method for Stack...
    void push(int x){
        if(top >= size - 1){
            System.out.println("Stack overflow.");
        }else {
            top++;
            s[top] = x;
            System.out.println(x+" is inserted.");
        }
    }
    // for POP Method for Stack...
    void pop() {
        if(top == -1){
            System.out.println("Stack underflow.");
        }else {
            top--;
            System.out.println(s[top+1]+" is deleted.");
        }
    }
    // for PEEP Method for Stack...
    void peep(){
        System.out.print("Enter Index no. u want to Fetch.: ");
        int fetch = sc.nextInt();
        if(top - fetch + 1<= -1){
            System.out.println("Stack underflow.");
        }else {
            System.out.println(s[top - fetch + 1]+" is fetch.");
        }
    }
    // for CHANGE Method for Stack...
    void change() {
        System.out.print("Enter Index no. you want to change.: ");
        int change = sc.nextInt();
        System.out.print("Enter no. you want to change.: ");
        int num = sc.nextInt();
        
        if(top - change +1 <= -1){
            System.out.println("Stack underflow.");
        }else {
            s[top - change + 1] =  num;
            System.out.println(s[top - change + 1]+" is changed.");
        }
    }
    void display(){
        System.out.println("----STACK----");
        for(int i = top; i >= 0 ; i--){
            System.out.println(s[i]);
        }
        System.out.println("-------------");
    }
}