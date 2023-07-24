package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSum2Test {

    @Test
    void combinationSum2() {

        int[] array = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> expected = List.of(
                List.of(1, 1, 6),
                List.of(1, 2, 5),
                List.of(1, 7),
                List.of(2, 6)

        );
        List<List<Integer>> lists = CombinationSum2.combinationSum2(array, target);

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