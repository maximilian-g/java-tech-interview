package com.maximilian.interview.common;

/**
 * <a href="https://leetcode.com/problems/alternating-groups-ii/description">Link to a task</a>
 * <p>
 * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k.
 * The color of tile i is represented by colors[i]:
 * <p>
 * colors[i] == 0 means that tile i is red.
 * colors[i] == 1 means that tile i is blue.
 * An alternating group is every k contiguous tiles in the circle with alternating colors
 * (each tile in the group except the first and last one has a different color from its left and right tiles).
 * <p>
 * Return the number of alternating groups.
 * <p>
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 * <p>
 * Constraints:
 * <p>
 * 3 <= colors.length <= 10^5
 * 0 <= colors[i] <= 1
 * 3 <= k <= colors.length
 */
public class NumberOfAlternatingGroups {

    // sliding window approach
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0;

        int[] colorsTemp = new int[colors.length + k - 1];
        System.arraycopy(colors, 0, colorsTemp, 0, colors.length);
        System.arraycopy(colors, 0, colorsTemp, colors.length, k - 1);
        int left = 0;
        for (int right = 0; right < colorsTemp.length; right++) {
            if (right > 0 && colorsTemp[right] == colorsTemp[right - 1]) {
                left = right;
            }

            if (right - left + 1 >= k) {
                result++;
            }
        }
        return result;
    }

    // brute force approach
    public static int numberOfAlternatingGroupsBruteForce(int[] colors, int k) {
        int result = 0;

        int[] colorsTemp = new int[colors.length + k - 1];
        System.arraycopy(colors, 0, colorsTemp, 0, colors.length);
        System.arraycopy(colors, 0, colorsTemp, colors.length, k - 1);
        for (int i = 0; i < colorsTemp.length - k; i++) {
            boolean foundGroup = true;
            for (int j = 0; j < k - 1; j++) {
                if (colorsTemp[j + i] == colorsTemp[j + i + 1]) {
                    foundGroup = false;
                    break;
                }
            }
            if (foundGroup) {
                result++;
            }
        }
        return result;
    }


}
