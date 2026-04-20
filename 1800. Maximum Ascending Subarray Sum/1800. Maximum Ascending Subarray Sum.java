/*
 * Problem: 1800. Maximum Ascending Subarray Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-ascending-subarray-sum/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maxAscendingSum(int[] nums) {
        int prv = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= prv) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            res = Math.max(sum, res);
            prv = nums[i];
        }
        return res;
    }
}
