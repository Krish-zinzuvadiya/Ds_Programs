import java.util.*;

class Pb125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value :");
        int n = sc.nextInt();
        Fibbo f1 = new Fibbo();
        for(int i=0;i<n;i++){
            System.out.print(f1.printfibo(i)+" ");
        }
    }
}
class Fibbo {
    int a=0;
    int b=1;
    int c;

    int printfibo(int n){
        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        } else {
            return printfibo(n-1) + printfibo(n-2);
        }
    }
}