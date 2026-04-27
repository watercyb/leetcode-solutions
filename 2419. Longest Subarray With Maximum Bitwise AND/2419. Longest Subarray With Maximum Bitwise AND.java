/*
 * Problem: 2419. Longest Subarray With Maximum Bitwise AND
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int max = 0;
        int count = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        for (int num : nums) {
            if (num == max) {
                count++;
                if (res < count)
                    res++;
            } else {
                count = 0;
            }
        }
        return res;
    }
}
