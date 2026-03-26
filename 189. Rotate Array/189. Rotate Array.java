/*
 * Problem: 189. Rotate Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rotate-array/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int stp = k % nums.length;
        rev(nums, 0, nums.length - 1);
        rev(nums, 0, stp - 1);
        rev(nums, stp, nums.length - 1);
    }

    public void rev(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
