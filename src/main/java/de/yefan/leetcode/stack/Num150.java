package de.yefan.leetcode.stack;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class Num150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(calculate(tokens[i], num1, num2));
            } else {
                int number = Integer.parseInt(tokens[i]);
                stack.push(number);
            }
        }

        return stack.pop();
    }

    private int calculate(String op, int f1, int f2) {
        if (op.equals("+")) {
            return f1 + f2;
        }
        if (op.equals("-")) {
            return f1 - f2;
        }
        if (op.equals("*")) {
            return f1 * f2;
        }
        if (op.equals("/")) {
            return f1 / f2;
        }
        throw new RuntimeException(op + " is not supported");
    }

}
