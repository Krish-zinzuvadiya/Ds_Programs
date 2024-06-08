import java.util.Scanner;

class Pb128 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value of X :");
        double x = sc.nextDouble();
        System.out.print("Enter Value of Y:");
        double y = sc.nextDouble();
        Number n1 = new Number();
        System.out.println(n1.printgcd(x, y));
    }
}
class Number {
    double printgcd(double x, double y){
        if(x==y){
            return x;
        } else {
            return printgcd(y, y%x);
        }
    }
}