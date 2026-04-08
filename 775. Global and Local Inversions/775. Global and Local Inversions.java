/*
 * Problem: 775. Global and Local Inversions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/global-and-local-inversions/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(max, nums[i - 2]);
            if (max > nums[i])
                return false;
        }
        return true;
    }
}
