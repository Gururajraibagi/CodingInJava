package begineer.medium.stack;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String[] tokens = new String[] {"2", "1", "+", "3", "*"};
        String[] tokens2 = new String[] {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens2));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            int res;
            switch (s) {
                case "+":
                    int a = (stack.pop());
                    int b = (stack.pop());
                    stack.push(a + b);
                    break;
                case "-":
                    int aa = (stack.pop());
                    int bb = (stack.pop());
                    stack.push(aa - bb);

                    break;
                case "*":
                    int a2 = stack.pop();
                    int b2 = stack.pop();
                    stack.push(a2 * b2);

                    break;
                case "/":
                    int a3 = stack.pop();
                    int b3 = stack.pop();
                    stack.push(b3 / a3);

                    break;
                default:
                    stack.push(Integer.parseInt(s));

            }
        }
        return stack.peek();
    }
}
