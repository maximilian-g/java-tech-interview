package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSum3Test {

    @Test
    void combinationSum3() {

        int k = 3;
        int n = 7;
        List<List<Integer>> expected = List.of(List.of(1, 2, 4));
        List<List<Integer>> result = CombinationSum3.combinationSum3(k, n);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            List<Integer> expectedList = expected.get(i);
            List<Integer> resultList = result.get(i);
            Assertions.assertEquals(expectedList.size(), resultList.size());
            for (int j = 0; j < expectedList.size(); j++) {
                Assertions.assertEquals(expectedList.get(j), resultList.get(j));
            }
        }

    }

}