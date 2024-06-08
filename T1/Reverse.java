import java.util.Scanner;

class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String You Want To Reverse: ");
        String str = sc.next();
        Rev r = new Rev(str.length());
        System.out.println("The Reverse String is : "+r.printRev(str));
    }    
}
class Rev{
    char rev[];
    int size,top;
    String r ="";
    Rev(int x){
        rev = new char[x];
        top=-1;
        size=x;
    }
    void push(char c){
        top++;
        rev[top]=c;
    }
    char pop(){
        top--;
        return rev[top+1];
    }
    String printRev(String str){
        for(int i=0;i<str.length();i++){
            push(str.charAt(i));
        }
            for(int i=0;i<str.length();i++){
                r=r+pop();
            }
        return r;
    }
}