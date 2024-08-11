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

class PrefixEvaluator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the prefix expression: ");
        String prefix = sc.next();

        MyStack stack = new MyStack(prefix.length());

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                int result = 0;

                switch (c) {
                    case '+':
                        result = Integer.parseInt(operand1) + Integer.parseInt(operand2);
                        break;
                    case '-':
                        result = Integer.parseInt(operand1) - Integer.parseInt(operand2);
                        break;
                    case '*':
                        result = Integer.parseInt(operand1) * Integer.parseInt(operand2);
                        break;
                    case '/':
                        result = Integer.parseInt(operand1) / Integer.parseInt(operand2);
                        break;
                }

                stack.push(String.valueOf(result));
            }
        }

        System.out.println("Result: " + stack.pop());
    }
}