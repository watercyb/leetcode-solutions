/*
 * Problem: 3702. Longest Subsequence With Non-Zero Bitwise XOR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean nonZero = false;
        for (int num : nums) {
            xor ^= num;
            if (num != 0)
                nonZero = true;
        }
        if (xor != 0)
            return nums.length;
        if (nonZero)
            return nums.length - 1;
        return 0;
    }
}
