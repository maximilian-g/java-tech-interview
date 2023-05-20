package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class GenerateParenthesisTest {

    @Test
    void testGenerateParenthesis() {
        int n = 2;
        Set<String> expectedSet = Set.of("()()", "(())");
        for (String generatedParenthesis : GenerateParenthesis.generateParenthesis(n)) {
            Assertions.assertTrue(expectedSet.contains(generatedParenthesis));
        }

        n = 3;
        expectedSet = Set.of("((()))", "(()())", "(())()", "()(())", "()()()");
        for (String generatedParenthesis : GenerateParenthesis.generateParenthesis(n)) {
            Assertions.assertTrue(expectedSet.contains(generatedParenthesis));
        }
    }

}