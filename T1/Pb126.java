import java.util.Scanner;

class Pb126 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value of X :");
        int x = sc.nextInt();
        System.out.print("Enter Value of Y:");
        int y = sc.nextInt();
        Power p = new Power();
        System.out.println("Ans is :- "+p.print(x,y));
    }    
}
class Power{
    double print(int x, int y){
        if(x==0){
            return 0;
        } else if(y==0){
            return 1;
        } else {
            return Math.pow(x, y);
        }
    }
}