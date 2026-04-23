/*
 * Problem: 2016. Maximum Difference Between Increasing Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-difference-between-increasing-elements/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                res = Math.max(nums[i] - min, res);
            } else {
                min = nums[i];
            }
        }
        return res;
    }
}
