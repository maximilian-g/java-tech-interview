package com.maximilian.interview.common.backtrack;

import java.util.Arrays;

/**
 * You are given an integer array matchsticks where matchsticks[i]
 * is the length of the ith matchstick.
 * You want to use all the matchsticks to make one square.
 * You should not break any stick, but you can link them up,
 * and each matchstick must be used exactly one time.
 * <p>
 * Return true if you can make this square and false otherwise.
 * <p>
 * Constraints:
 * <p>
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 10^8
 */
public class MatchsticksToSquare {

    public static boolean makesquare(int[] matchsticks) {
        int matchsticksSum = Arrays.stream(matchsticks).sum();
        if (matchsticks.length < 4 || matchsticksSum % 4 != 0) {
            return false;
        }
        int side = matchsticksSum / 4;
        return backtrack(matchsticks, side, 0,
                0, 4, new boolean[matchsticks.length]);
    }

    private static boolean backtrack(int[] matchsticks, int sideSize, int currentSum,
                                     int index, int sidesLeft, boolean[] usedIndices) {
        // found all sides
        if (sidesLeft == 0) {
            return true;
        }
        // found new side
        if (sideSize == currentSum) {
            return backtrack(matchsticks, sideSize, 0,
                    0, sidesLeft - 1, usedIndices);
        }

        for (int i = index; i < matchsticks.length; i++) {
            if (!usedIndices[i] && currentSum + matchsticks[i] <= sideSize) {
                usedIndices[i] = true;
                if (backtrack(matchsticks, sideSize, currentSum + matchsticks[i],
                        i + 1, sidesLeft, usedIndices)) {
                    return true;
                }
                usedIndices[i] = false;
            }
        }
        return false;
    }

}
