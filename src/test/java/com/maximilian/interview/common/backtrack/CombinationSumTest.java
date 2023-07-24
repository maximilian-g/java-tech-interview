package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSumTest {

    @Test
    void combinationSum() {
        int[] array = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = List.of(
                List.of(2, 2, 3),
                List.of(7)
        );
        List<List<Integer>> lists = CombinationSum.combinationSum(array, target);

        Assertions.assertEquals(expected.size(), lists.size());

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> expectedAnswer = expected.get(i);
            List<Integer> actualAnswer = lists.get(i);
            Assertions.assertEquals(expectedAnswer.size(), actualAnswer.size());
            for (int j = 0; j < expectedAnswer.size(); j++) {
                Assertions.assertEquals(expectedAnswer.get(j), actualAnswer.get(j));
            }
        }

    }

}