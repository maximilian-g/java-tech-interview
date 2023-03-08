package com.maximilian.interview.stack;


import java.util.Stack;

/**
 * You are given an array of strings tokens that represent an arithmetic expression in a Reverse Polish Notation.
 * <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Reverse Polish Notation</a>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * <p>
 * - The valid operators are '+', '-', '*', and '/'.
 * - Each operand may be an integer or another expression.
 * - The division between two integers always truncates toward zero.
 * - There will not be any division by zero.
 * - The input represents a valid arithmetic expression in a reverse polish notation.
 * - The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * <p>
 * Constraints:
 * <p>
 * 1 <= tokens.length <= 10^4
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                values.push(values.pop() + values.pop());
            } else if ("-".equals(token)) {
                // - values.pop() because of (4, 3, -) - should be 4 - 3, not 3 - 4
                values.push(-values.pop() + values.pop());
            } else if ("*".equals(token)) {
                values.push(values.pop() * values.pop());
            } else if ("/".equals(token)) {
                values.push((int) (1. / values.pop() * values.pop()));
            } else {
                values.push(Integer.valueOf(token));
            }
        }
        return values.pop();
    }

}
