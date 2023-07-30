package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PalindromePartitioningTest {

    @Test
    void partition() {

        String s = "aab";
        List<List<String>> expected = List.of(
                List.of("a", "a", "b"),
                List.of("aa", "b")
        );
        List<List<String>> result = PalindromePartitioning.partition(s);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            List<String> expectedList = expected.get(i);
            List<String> resultList = result.get(i);
            Assertions.assertEquals(expectedList.size(), resultList.size());
            for (int j = 0; j < resultList.size(); j++) {
                Assertions.assertEquals(expectedList.get(j), resultList.get(j));
            }
        }

    }

}