package com.maximilian.interview.queue;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Implement KthLargest class:
 * <p>
 * KthLargest(int k, int[] nums)
 * Initializes the object with the integer k and the stream of integers nums.
 * <p>
 * int add(int val)
 * Appends the integer val to the stream and returns the element
 * representing the kth largest element in the stream.
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= 10^4
 * 0 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * -10^4 <= val <= 10^4
 * At most 10^4 calls will be made to add.
 * It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 */
public class KthLargestElement {

    private final Queue<Integer> queue;
    private final int k;

    public KthLargestElement(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            this.add(num);
        }
    }

    public final int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

}
