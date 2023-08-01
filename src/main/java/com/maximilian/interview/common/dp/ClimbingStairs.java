package com.maximilian.interview.common.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n < 2) {
            return n;
        }

        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;

        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    public static int climbStairsBruteForce(int n) {
        if (n < 2) {
            return n;
        }
        return climbStairsBruteForce(0, n);
    }

    public static int climbStairsBruteForceWithCache(int n) {
        if (n < 2) {
            return n;
        }
        return climbStairsBruteForceWithCache(0, n, new HashMap<>());
    }

    private static int climbStairsBruteForceWithCache(int currentStep,
                                                      int target,
                                                      Map<Integer, Integer> distinctWaysFromStep) {
        if (currentStep > target) {
            // overstep
            return 0;
        }
        if (currentStep == target) {
            // found solution
            return 1;
        }
        int currentStepPlusOne = currentStep + 1;
        int currentStepPlusTwo = currentStep + 2;
        // filling cache for 2 possible subtrees
        if (!distinctWaysFromStep.containsKey(currentStepPlusOne)) {
            distinctWaysFromStep.put(currentStepPlusOne,
                    climbStairsBruteForceWithCache(currentStepPlusOne, target, distinctWaysFromStep));
        }
        if (!distinctWaysFromStep.containsKey(currentStepPlusTwo)) {
            distinctWaysFromStep.put(currentStepPlusTwo,
                    climbStairsBruteForceWithCache(currentStepPlusTwo, target, distinctWaysFromStep));
        }
        return distinctWaysFromStep.get(currentStepPlusOne) +
                distinctWaysFromStep.get(currentStepPlusTwo);
    }

    private static int climbStairsBruteForce(int currentStep, int target) {
        if (currentStep > target) {
            // overstep
            return 0;
        }
        if (currentStep == target) {
            // found solution
            return 1;
        }
        return climbStairsBruteForce(currentStep + 1, target) +
                climbStairsBruteForce(currentStep + 2, target);
    }

}
