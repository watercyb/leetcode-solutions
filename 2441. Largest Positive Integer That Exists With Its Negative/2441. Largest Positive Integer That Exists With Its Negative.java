/*
 * Problem: 2441. Largest Positive Integer That Exists With Its Negative
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int findMaxK(int[] nums) {
        boolean[] seens = new boolean[2001];
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            seens[1000 - nums[i]] = true;
            if (seens[nums[i] + 1000])
                res = Math.max(Math.abs(nums[i]), res);
        }
        return res;
    }
}
