import java.util.Scanner;

public class Code {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the postfix expression: ");
        String s = scanner.nextLine();
        
        System.out.println("Postfix Expression: " + s);
        System.out.println("Evaluation Result: " + evaluatePostfix(s));
    }

    public static int evaluatePostfix(String s) {
        int[] s1 = new int[s.length()]; 
        int top = -1; 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                s1[++top] = c - '0'; 
            } else if (c == ' ') {
                continue;
            } else {
                int operand2 = s1[top--];
                int operand1 = s1[top--];
                
                // Perform the operation and push the result back onto the stack
                switch (c) {
                    case '+':
                        s1[++top] = operand1 + operand2;
                        break;
                    case '-':
                        s1[++top] = operand1 - operand2;
                        break;
                    case '*':
                        s1[++top] = operand1 * operand2;
                        break;
                    case '/':
                        s1[++top] = operand1 / operand2;
                        break;
                    case '^':
                        s1[++top] = (int) Math.pow(operand1, operand2);
                        break;
                    case '$':
                        s1[++top] = (int) Math.pow(operand1, operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid postfix expression");
                }
            }
        }
        return s1[top];
    } 
}
