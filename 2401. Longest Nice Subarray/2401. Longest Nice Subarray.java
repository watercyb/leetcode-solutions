/*
 * Problem: 2401. Longest Nice Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-nice-subarray/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int and = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; j < nums.length; i++) {
            while (j < nums.length && (and & nums[j]) == 0) {
                and += nums[j];
                j++;
            }
            if (j - i > res)
                res = j - i;
            and ^= nums[i];
        }
        return res;
    }
}
