package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Permutations2Test {

    @Test
    void permuteUnique() {

        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> expected = List.of(
                List.of(1, 1, 2),
                List.of(1, 2, 1),
                List.of(2, 1, 1)
        );

        List<List<Integer>> result = Permutations2.permuteUnique(nums);
        Assertions.assertEquals(expected.size(), result.size());

        for (int i = 0; i < result.size(); i++) {
            List<Integer> expectedAnswer = expected.get(i);
            List<Integer> actualAnswer = result.get(i);
            Assertions.assertEquals(expectedAnswer.size(), actualAnswer.size());
            for (int j = 0; j < expectedAnswer.size(); j++) {
                Assertions.assertEquals(expectedAnswer.get(j), actualAnswer.get(j));
            }
        }

    }

}