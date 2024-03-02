package com.maximilian.interview.common.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations
 * of k numbers chosen from the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,
                new ArrayList<>(),
                n, k, 1);
        return result;
    }

    private static void backtrack(List<List<Integer>> result,
                                  List<Integer> currentList,
                                  int n, int k, int start) {
        if (currentList.size() == k) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i <= n; i++, start++) {
            currentList.add(i);
            backtrack(result, currentList, n, k, start + 1);
            currentList.remove(currentList.size() - 1);
        }
    }

}
