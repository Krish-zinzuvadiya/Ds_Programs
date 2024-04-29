import java.util.Scanner;

public class SimpleQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size :- ");
        int size = sc.nextInt();
        Queue q = new Queue(size);
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Insert The Element.");
            System.out.println("2. Delete The Element.");
            System.out.println("3. Exit.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    q.insert();
                    q.display();
                    break;
                case 2:
                    q.delete();
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
    int q1[];
    int f,r,n,y;
    Scanner sc= new Scanner(System.in);
    Queue(int n){
        q1 = new int[n];
        this.n=n;
        f = -1;
        r = -1;
    }
    void insert(){
        if(r>=n-1){
            System.out.println("Queue is Overflow.");
        } else {
            System.out.print("Enter The Element :- ");
            int y = sc.nextInt();
            r++;
            q1[r] = y;
            System.out.println(y+" Inserted.");
        }
        if(f == -1){
            f = 0;
        }
    }

    void delete(){
        if(f == -1){
            System.out.println("Queue is Underflow.");
        } else {
            System.out.println(q1[f]+" Deleted.");
        }
            if(f==r){
                f = -1;
                r = -1;
            } else {
                f++;
            }
        }
        void display(){
            if(f==-1){
                System.out.println("Queue is Empty.");
            } else {
                System.out.println("--------------------");
                for(int i=f;i<=r;i++){
                    System.out.print(q1[i]+" ");
                }
                System.out.println();
                System.out.println("--------------------");
        }
    }
}
