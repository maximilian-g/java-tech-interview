package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PhoneNumberLetterCombinationsTest {

    @Test
    void letterCombinations() {

        String input = "23";
        List<String> expected = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> result = PhoneNumberLetterCombinations.letterCombinations(input);
        Assertions.assertEquals(expected.size(), result.size());
        for (String resultElement : result) {
            Assertions.assertTrue(expected.contains(resultElement));
        }

        input = "";
        result = PhoneNumberLetterCombinations.letterCombinations(input);
        Assertions.assertEquals(0, result.size());

    }

}