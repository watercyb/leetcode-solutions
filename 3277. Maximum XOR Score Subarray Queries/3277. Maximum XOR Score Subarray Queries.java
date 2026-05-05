/*
 * Problem: 3277. Maximum XOR Score Subarray Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-xor-score-subarray-queries/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int[][] DP = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            DP[i][i] = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                DP[i][j] = DP[i][j + 1] ^ DP[i - 1][j];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                DP[i][j] = Math.max(DP[i][j], Math.max(DP[i][j + 1], DP[i - 1][j]));
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = DP[queries[i][1]][queries[i][0]];
        }
        return res;
    }
}
