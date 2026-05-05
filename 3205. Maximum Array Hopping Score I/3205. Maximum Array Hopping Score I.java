/*
 * Problem: 3205. Maximum Array Hopping Score I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-array-hopping-score-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maxScore(int[] nums) {
        int res = 0;
        int max = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            max = Math.max(nums[i], max);
            res += max;
        }
        return res;
    }
}
