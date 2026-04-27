/*
 * Problem: 2444. Count Subarrays With Fixed Bounds
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int min = -1;
        int max = -1;
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                j = i;
                min = i;
                max = i;
            } else {
                if (nums[i] == minK)
                    min = i;
                if (nums[i] == maxK)
                    max = i;
                res += Math.min(min, max) - j;
            }
        }
        return res;
    }
}
