/*
 * Problem: 213. House Robber II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/house-robber-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));
    }

    public int getMax(int[] nums, int l, int r) {
        int a = 0;
        int b = 0;
        for (int i = l; i <= r; i++) {
            int numTemp = a;
            a = Math.max(a, b);
            b = numTemp + nums[i];
        }
        return Math.max(a, b);
    }
}
