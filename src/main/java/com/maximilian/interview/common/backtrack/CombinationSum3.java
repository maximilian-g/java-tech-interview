package com.maximilian.interview.common.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iii/description">Link to a task</a>
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * <p>
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations.
 * The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 * <p>
 * Constraints:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class CombinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new ArrayList<>(k), k, n, 1);
        return result;
    }


    private static void backtrack(List<List<Integer>> result,
                                  List<Integer> currentIntegerList,
                                  int k,
                                  int n,
                                  int start) {
        if (currentIntegerList.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(currentIntegerList));
            }
            return;
        }
        for (int i = start; i < 10; i++) {
            currentIntegerList.add(i);
            backtrack(result, currentIntegerList, k, n - i, i + 1);
            currentIntegerList.removeLast();
        }
    }

}
