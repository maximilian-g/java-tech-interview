package com.maximilian.interview.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>(List.of(""));
        }
        List<String> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (String leftString : generateParenthesis(i)) {
                for (String rightString : generateParenthesis(n - i - 1)) {
                    result.add("(" + leftString + ")" + rightString);
                }
            }
        }
        return result;
    }

}
