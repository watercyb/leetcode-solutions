/*
 * Problem: 3788. Maximum Score of a Split
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-score-of-a-split/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long maximumScore(int[] nums) {
        int[] mins = new int[nums.length];
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            mins[i] = min;
            min = Math.min(min, nums[i]);
        }
        long sum = 0;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            res = Math.max(res, sum - mins[i]);
        }
        return res;
    }
}
