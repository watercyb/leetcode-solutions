/*
 * Problem: 3641. Longest Semi-Repeating Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-semi-repeating-subarray/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        int j = 0;
        int res = 0;
        for (int i = 0; j < nums.length; i++) {
            while (j < nums.length && (k > 0 || counts[nums[j]] != 1)) {
                if (counts[nums[j++]]++ == 1)
                    k--;
            }
            res = Math.max(j - i, res);
            if (counts[nums[i]]-- == 2)
                k++;
        }
        return res;
    }
}
