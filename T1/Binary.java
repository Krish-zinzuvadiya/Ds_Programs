import java.util.Scanner;

class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = sc.nextInt();
        DtoB db = new DtoB();
        db.print(n);
    }
}
class DtoB {
    int top = -1;
    int s[] = new int[100];

    void print(int n) {
        while (n > 0) {
            push(n % 2);
            n = n / 2;
        }
        while (top != -1) {
            pop();
        }
    }
    void push(int n) {
        top++;
        s[top] = n;
    }
    void pop() {
        top--;
        System.out.print(s[top + 1]+" ");
    }
}
