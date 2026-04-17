/*
 * Problem: 1493. Longest Subarray of 1's After Deleting One Element
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int j = 0;
        int n = 1;
        for (int i = 0; i < nums.length; i++) {
            n += nums[i] - 1;
            if (n < 0) {
                n += 1 - nums[j];
                j++;
            }
        }
        return nums.length - j - 1;
    }
}
