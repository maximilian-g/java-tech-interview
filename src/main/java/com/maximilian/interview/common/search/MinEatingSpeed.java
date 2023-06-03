package com.maximilian.interview.common.search;

import java.util.Arrays;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k.
 * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and
 * will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Constraints:
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 * <p>
 * Example:
 * <p>
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 */
public class MinEatingSpeed {

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatInTime(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canEatInTime(int[] piles, int valuesPerHour, int hours) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (valuesPerHour >= pile ? 1 : (pile / valuesPerHour) + 1);
        }
        return hours >= totalHours;
    }

}
