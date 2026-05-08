/*
 * Problem: 3584. Maximum Product of First and Last Elements of a Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-product-of-first-and-last-elements-of-a-subsequence/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long maximumProduct(int[] nums, int m) {
        if (m == 1) {
            long res = Long.MIN_VALUE;
            for (int n : nums) {
                res = Math.max((long) n * n, res);
            }
            return res;
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long res = Long.MIN_VALUE;
        for (int i = m - 1; i < nums.length; i++) {
            max = Math.max(nums[i - m + 1], max);
            min = Math.min(nums[i - m + 1], min);
            res = Math.max(Math.max(max * nums[i], min * nums[i]), res);
        }
        return res;
    }
}
