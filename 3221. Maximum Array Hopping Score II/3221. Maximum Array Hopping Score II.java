/*
 * Problem: 3221. Maximum Array Hopping Score II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-array-hopping-score-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long maxScore(int[] nums) {
        long res = 0;
        int max = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            max = Math.max(nums[i], max);
            res += max;
        }
        return res;
    }
}
