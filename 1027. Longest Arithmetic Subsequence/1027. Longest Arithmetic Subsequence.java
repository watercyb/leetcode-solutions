/*
 * Problem: 1027. Longest Arithmetic Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-arithmetic-subsequence/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[][] DP = new int[nums.length][max * 2 + 1];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j] + max;
                if (DP[i][diff]!=0) continue;
                DP[i][diff] = DP[j][diff] + 1;
                res = Math.max(DP[i][diff], res);
            }
        }
        return res + 1;
    }
}
