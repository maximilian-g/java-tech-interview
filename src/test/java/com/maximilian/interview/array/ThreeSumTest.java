package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ThreeSumTest {

    @Test
    void threeSum() {

        List<List<Integer>> result = List.of(List.of(0, 0, 0));
        List<List<Integer>> response = ThreeSum.threeSum(new int[]{0, 0, 0});
        Assertions.assertIterableEquals(result, response);

        response = ThreeSum.threeSum(new int[]{0, 0, 1});
        Assertions.assertEquals(0, response.size());

        response = ThreeSum.threeSum(new int[]{0, 1, 1});
        Assertions.assertEquals(0, response.size());

        response = ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assertions.assertEquals(2, response.size());

        Set<List<Integer>> tripletSet = new HashSet<>();
        tripletSet.add(List.of(-1, -1, 2));
        tripletSet.add(List.of(-1, 0, 1));

        for (List<Integer> triplet : response) {
            triplet.sort(Comparator.naturalOrder());
            Assertions.assertTrue(tripletSet.contains(triplet));
        }

    }

}