/*
 * Problem: 3409. Longest Subsequence With Decreasing Adjacent Difference
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-subsequence-with-decreasing-adjacent-difference/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int longestSubsequence(int[] nums) {
        int[][] DP = new int[301][301];
        int res = 0;
        for (int num : nums) {
            int max = 0;
            for (int i = Math.max(num - 1, 300 - num); i >= 0; i--) {
                int l = num - i;
                int r = num + i;
                if (l >= 1)
                    max = Math.max(max, DP[l][num]);
                if (r <= 300)
                    max = Math.max(max, DP[r][num]);
                if (l >= 1)
                    DP[num][l] = Math.max(DP[num][l], max + 1);
                if (r <= 300)
                    DP[num][r] = Math.max(DP[num][r], max + 1);
                res = Math.max(max, res);
            }
        }
        return res + 1;
    }
}
