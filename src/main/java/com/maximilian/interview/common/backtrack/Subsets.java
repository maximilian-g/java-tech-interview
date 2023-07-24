package com.maximilian.interview.common.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 * (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int subsetSize = 0; subsetSize < nums.length + 1; subsetSize++) {
            backtrack(0, new ArrayList<>(subsetSize), nums, subsetSize, result);
        }
        return result;
    }

    private static void backtrack(int first, ArrayList<Integer> curr,
                                  int[] nums, int subsetSize,
                                  List<List<Integer>> result) {
        // if the combination is done
        if (curr.size() == subsetSize) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = first; i < nums.length; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums, subsetSize, result);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

}
