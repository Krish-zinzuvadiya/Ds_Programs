import java.util.Scanner;

public class Pb127 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value of X :");
        int x = sc.nextInt();
        Number n = new Number();
        System.out.println("The Sum Of Digits :- "+n.printNum(x));
    }
}
class Number{
    int printNum(int x){
        if(x==0){
        return 0;
        } else {
            return x%10 + printNum(x/10);
        }
    }
}