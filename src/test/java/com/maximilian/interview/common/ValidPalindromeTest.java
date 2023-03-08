package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidPalindromeTest {

    @Test
    void isPalindrome() {

        Assertions.assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertTrue(ValidPalindrome.isPalindrome(" "));
        Assertions.assertFalse(ValidPalindrome.isPalindrome("race a car"));

    }

}