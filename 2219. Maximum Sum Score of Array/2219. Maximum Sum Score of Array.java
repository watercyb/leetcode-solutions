/*
 * Problem: 2219. Maximum Sum Score of Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-sum-score-of-array/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long maximumSumScore(int[] nums) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        long sum = 0;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, Math.max(sum, total - sum + nums[i]));
        }
        return res;
    }
}
