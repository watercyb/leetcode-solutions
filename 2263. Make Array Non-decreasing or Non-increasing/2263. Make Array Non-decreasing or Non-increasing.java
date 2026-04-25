/*
 * Problem: 2263. Make Array Non-decreasing or Non-increasing
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/make-array-non-decreasing-or-non-increasing/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int convertArray(int[] nums) {
        return Math.min(getMin(nums, true), getMin(nums, false));
    }

    public int getMin(int[] nums, boolean nonInc) {
        int res = 0;
        PriorityQueue<Integer> PQ = nonInc ? new PriorityQueue<>((a, b) -> b - a) : new PriorityQueue<>();
        PQ.offer(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if ((nonInc && PQ.peek() > nums[i]) || (!nonInc && PQ.peek() < nums[i])) {
                res += Math.abs(PQ.poll() - nums[i]);
                PQ.offer(nums[i]);
            }
            PQ.offer(nums[i]);
        }
        return res;
    }
}
