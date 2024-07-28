package com.maximilian.interview.common.search;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description">
 * Link to a task</a>
 * You are given two positive integer arrays spells and potions, of
 * length n and m respectively, where spells[i] represents the strength
 * of the ith spell and potions[j] represents the strength of the jth potion.
 * <p>
 * You are also given an integer success. A spell and potion pair
 * is considered successful if the product of their strengths is at least success.
 * <p>
 * Return an integer array pairs of length n where pairs[i] is
 * the number of potions that will form a successful pair with the ith spell.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * Output: [4,0,3]
 * Explanation:
 * - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
 * - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
 * - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
 * Thus, [4,0,3] is returned.
 * <p>
 * Constraints:
 * <p>
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 10^5
 * 1 <= spells[i], potions[i] <= 10^5
 * 1 <= success <= 10^10
 */
public class SuccessfulPairsOfSpellsAndPotions {

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            long minPotion = (success / spells[i]) + (success % spells[i] > 0 ? 1 : 0);
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= minPotion) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            pairs[i] = potions.length - left;
        }
        return pairs;
    }

}
