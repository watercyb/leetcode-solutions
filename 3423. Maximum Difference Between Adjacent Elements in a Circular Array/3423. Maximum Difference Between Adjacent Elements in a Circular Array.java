/*
 * Problem: 3423. Maximum Difference Between Adjacent Elements in a Circular Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int res = Math.abs(nums[0] - nums[nums.length - 1]);
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(Math.abs(nums[i] - nums[i - 1]), res);
        }
        return res;
    }
}
