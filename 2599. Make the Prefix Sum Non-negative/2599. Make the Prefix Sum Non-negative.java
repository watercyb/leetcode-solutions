/*
 * Problem: 2599. Make the Prefix Sum Non-negative
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/make-the-prefix-sum-non-negative/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        long sum = 0;
        int res = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] < 0)
                PQ.offer(nums[i]);
            while (sum < 0) {
                sum -= PQ.poll();
                res++;
            }
        }
        return res;
    }
}
