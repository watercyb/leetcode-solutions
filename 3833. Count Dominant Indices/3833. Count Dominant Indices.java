/*
 * Problem: 3833. Count Dominant Indices
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-dominant-indices/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int dominantIndices(int[] nums) {
        int res = 0;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (nums[i] >= sum / (nums.length - i) + 1)
                res++;
        }
        return res;
    }
}
