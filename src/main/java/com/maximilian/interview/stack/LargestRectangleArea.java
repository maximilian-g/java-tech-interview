package com.maximilian.interview.stack;

import java.util.Stack;

/**
 * Given an array of integers heights representing the
 * histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * <p>
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * <p>
 * Constraints:
 * <p>
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 */
public class LargestRectangleArea {

    // O(n^2) approach
    public static int largestRectangleArea(int[] heights) {
        int maxHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            maxHeight = Math.max(maxHeight, heights[i]);
            int minElem = Integer.MAX_VALUE;
            for (int j = i + 1; j < heights.length; j++) {
                minElem = Math.min(minElem, Math.min(heights[j], heights[i]));
                maxHeight = Math.max(minElem * (j - i + 1), maxHeight);
            }
        }
        return maxHeight;
    }

    // O(n) approach
    public static int largestRectangleAreaFast(int[] heights) {
        Stack<Integer> heightIndexes = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length ? 0 : heights[i]);
            if (heightIndexes.isEmpty() || height >= heights[heightIndexes.peek()]) {
                heightIndexes.push(i);
            } else {
                int lastHeight = heights[heightIndexes.pop()];
                maxArea = Math.max(maxArea, lastHeight *
                        (heightIndexes.isEmpty() ? i : i - 1 - heightIndexes.peek()));
                i--;
            }
        }
        return maxArea;
    }

}
