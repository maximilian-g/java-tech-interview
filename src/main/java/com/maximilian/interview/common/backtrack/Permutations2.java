package com.maximilian.interview.common.backtrack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Input: nums = [1,1,2]
 * Output: [[1,1,2],[1,2,1],[2,1,1]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums may contain duplicates.
 */
public class Permutations2 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> quantityByNum = new HashMap<>();
        for (int num : nums) {
            quantityByNum.put(num, quantityByNum.getOrDefault(num, 0) + 1);
        }

        backtrack(result, new ArrayList<>(), quantityByNum, nums.length);

        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList,
                                  Map<Integer, Integer> quantityByNum, int numsLength) {
        if (tempList.size() == numsLength) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int num : quantityByNum.keySet()) {
            if (quantityByNum.get(num) == 0) {
                continue;
            }
            tempList.add(num);
            quantityByNum.put(num, quantityByNum.get(num) - 1);
            backtrack(list, tempList, quantityByNum, numsLength);
            tempList.remove(tempList.size() - 1);
            quantityByNum.put(num, quantityByNum.get(num) + 1);
        }
    }

}
