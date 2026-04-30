/*
 * Problem: 2717. Semi-Ordered Permutation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/semi-ordered-permutation/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int res = nums.length - 1;
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                res += i;
                diff = 1;
            } else if (nums[i] == nums.length) {
                res -= i;
                diff = 0;
            }
        }
        return res - diff;
    }
}
