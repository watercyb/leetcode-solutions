/*
 * Problem: 3151. Special Array I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/special-array-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public boolean isArraySpecial(int[] nums) {
        int mod = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            mod = 1 - mod;
            if (nums[i] % 2 != mod)
                return false;
        }
        return true;
    }
}
