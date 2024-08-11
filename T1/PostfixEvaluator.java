import java.util.*;

class MyStack {
    String s[];
    int top;
    int size;

    MyStack(int n) {
        s = new String[n];
        top = -1;
        size = n;
    }

    void push(String x) {
        if (top >= size - 1) {
            System.out.println("Stack overflow.");
        } else {
            top++;
            s[top] = x;
        }
    }

    String pop() {
        if (top == -1) {
            System.out.println("Stack underflow.");
            return "";
        } else {
            return s[top--];
        }
    }
}

class PostfixEvaluator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the postfix expression: ");
        String postfix = sc.next();

        MyStack stack = new MyStack(postfix.length());

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(String.valueOf(c));
                System.out.println(c + " is inserted.");
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                int result = 0;

                switch (c) {
                    case '+':
                        result = Integer.parseInt(operand2) + Integer.parseInt(operand1);
                        break;
                    case '-':
                        result = Integer.parseInt(operand2) - Integer.parseInt(operand1);
                        break;
                    case '*':
                        result = Integer.parseInt(operand2) * Integer.parseInt(operand1);
                        break;
                    case '/':
                        result = Integer.parseInt(operand2) / Integer.parseInt(operand1);
                        break;
                }

                stack.push(String.valueOf(result));
            }
        }

        System.out.println("Result: " + stack.pop());
    }
}