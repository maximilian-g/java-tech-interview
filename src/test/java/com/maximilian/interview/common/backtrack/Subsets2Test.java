package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Subsets2Test {

    @Test
    void subsetsWithDup() {

        // output order is not guaranteed in algorithm in general,
        // but for now test assumes that order will be following:
        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 2),
                List.of(2),
                List.of(2, 2)
        );

        List<List<Integer>> res = Subsets2.subsetsWithDup(new int[]{1, 2, 2});
        res.forEach(System.out::println);

        Assertions.assertEquals(expected.size(), res.size());
        for (int i = 0; i < expected.size(); i++) {
            List<Integer> expectedSubset = expected.get(i);
            List<Integer> resSubset = res.get(i);
            Assertions.assertEquals(expectedSubset.size(), resSubset.size());
            for (int j = 0; j < expectedSubset.size(); j++) {
                Assertions.assertEquals(expectedSubset.get(j), resSubset.get(j));
            }
        }

    }

}