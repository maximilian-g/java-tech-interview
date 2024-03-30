package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FindUniqueBinaryStringTest {

    @Test
    void findDifferentBinaryString() {

        String[] input = new String[]{"01", "10"};
        List<String> expectedList = List.of("11", "00");

        String result = FindUniqueBinaryString.findDifferentBinaryString(input);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(expectedList.contains(result));

        input = new String[]{"0"};
        expectedList = List.of("1");

        result = FindUniqueBinaryString.findDifferentBinaryString(input);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(expectedList.contains(result));

        input = new String[]{"111", "011", "001"};
        expectedList = List.of("101", "000", "010", "100", "110");

        result = FindUniqueBinaryString.findDifferentBinaryString(input);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(expectedList.contains(result));

    }

}