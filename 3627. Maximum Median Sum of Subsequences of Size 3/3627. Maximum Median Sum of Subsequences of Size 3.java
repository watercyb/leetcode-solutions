/*
 * Problem: 3627. Maximum Median Sum of Subsequences of Size 3
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-median-sum-of-subsequences-of-size-3/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = nums.length - 2; i >= nums.length / 3; i -= 2) {
            res += nums[i];
        }
        return res;
    }
}
