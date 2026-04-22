/*
 * Problem: 1920. Build Array from Permutation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/build-array-from-permutation/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
