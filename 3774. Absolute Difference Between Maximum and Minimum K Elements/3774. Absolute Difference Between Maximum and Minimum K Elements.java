/*
 * Problem: 3774. Absolute Difference Between Maximum and Minimum K Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/absolute-difference-between-maximum-and-minimum-k-elements/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < Math.min(k, nums.length - k); i++) {
            res += nums[nums.length - 1 - i] - nums[i];
        }
        return res;
    }
}
