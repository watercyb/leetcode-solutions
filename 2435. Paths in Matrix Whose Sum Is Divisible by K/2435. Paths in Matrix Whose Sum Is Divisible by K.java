/*
 * Problem: 2435. Paths in Matrix Whose Sum Is Divisible by K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int mod = 1_000_000_007;
        int[][] DP = new int[grid[0].length + 1][k];
        DP[1][0] = 1;
        int[][] DPNext = new int[grid[0].length + 1][k];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int l = 0; l < k; l++) {
                    DPNext[j + 1][(l + grid[i][j]) % k] = (DP[j + 1][l] + DPNext[j][l]) % mod;
                }
            }
            int[][] temp = DP;
            DP = DPNext;
            DPNext = temp;
        }
        return (int) DP[grid[0].length][0];
    }
}
