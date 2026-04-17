/*
 * Problem: 1480. Running Sum of 1d Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/running-sum-of-1d-array/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
