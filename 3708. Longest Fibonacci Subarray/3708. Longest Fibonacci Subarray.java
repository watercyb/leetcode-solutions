/*
 * Problem: 3708. Longest Fibonacci Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-fibonacci-subarray/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 2;
            while (j < nums.length && nums[j - 2] + nums[j - 1] == nums[j]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j - 1;
        }
        return res;
    }
}
