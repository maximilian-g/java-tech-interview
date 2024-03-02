package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationsTest {

    @Test
    void combine() {

        int n = 1;
        int k = 1;
        List<List<Integer>> expected = List.of(List.of(1));
        List<List<Integer>> result = Combinations.combine(n, k);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }

        n = 4;
        k = 2;
        expected = List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 3),
                List.of(2, 4),
                List.of(3, 4)
        );
        result = Combinations.combine(n, k);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }

        k = 3;
        expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 2, 4),
                List.of(1, 3, 4),
                List.of(2, 3, 4)
        );
        result = Combinations.combine(n, k);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

}