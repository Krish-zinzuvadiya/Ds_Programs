import java.util.Scanner;

class Pb124 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value : ");
        int n = sc.nextInt();

        Fact f = new Fact();
        System.out.println("The Factorial of N is : "+f.printFact(n));
    }    
}
class Fact{
    int printFact(int n){
        if(n==0){
            return 1;
        } else{
            return n*printFact(n-1);
        }
    }
}
