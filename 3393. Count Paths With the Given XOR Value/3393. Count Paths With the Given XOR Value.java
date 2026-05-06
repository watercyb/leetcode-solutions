/*
 * Problem: 3393. Count Paths With the Given XOR Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-paths-with-the-given-xor-value/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int countPathsWithXorValue(int[][] grid, int k) {
        int mod = 1_000_000_007;
        long[][] DP = new long[grid[0].length][16];
        int prv = 0;
        for (int i = 0; i < grid[0].length; i++) {
            prv ^= grid[0][i];
            DP[i][prv] = 1;
        }
        for (int i = 1; i < grid.length; i++) {
            long[] next = new long[16];
            for (int j = 0; j < 16; j++) {
                next[j ^ grid[i][0]] += DP[0][j];
            }
            DP[0] = next;
            for (int j = 1; j < grid[0].length; j++) {
                next = new long[16];
                for (int l = 0; l < 16; l++) {
                    next[l ^ grid[i][j]] += (DP[j - 1][l] + DP[j][l]) % mod;
                }
                DP[j] = next;
            }
        }
        return (int) (DP[DP.length - 1][k] % mod);
    }
}
