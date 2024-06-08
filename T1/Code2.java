import java.util.Scanner;

public class Code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the prefix expression: ");
        String s = scanner.nextLine();
        
        System.out.println("Prefix Expression: " + s);
        System.out.println("Evaluation Result: " + evaluatePrefix(s));
    }           

    public static int evaluatePrefix(String s) {
        int[] stack = new int[s.length()]; 
        int top = -1; 
        // Iterate through the expression in reverse order
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                stack[++top] = c - '0'; 
            } else if (c == ' ') {
                continue;
            } else {
                int operand1 = stack[top--];
                int operand2 = stack[top--];
                
                // Perform the operation and push the result back onto the stack
                switch (c) {
                    case '+':
                        stack[++top] = operand1 + operand2;
                        break;
                    case '-':
                        stack[++top] = operand1 - operand2;
                        break;
                    case '*':
                        stack[++top] = operand1 * operand2;
                        break;
                    case '/':
                        stack[++top] = operand1 / operand2;
                        break;
                    case '^':
                    case '$':
                        stack[++top] = (int) Math.pow(operand1, operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid prefix expression");
                }
            }
        }  
        // The result will be left on top of the stack.
        return stack[top];
    }
}