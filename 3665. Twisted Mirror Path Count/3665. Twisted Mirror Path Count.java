/*
 * Problem: 3665. Twisted Mirror Path Count
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/twisted-mirror-path-count/?envType=daily-question&envId=2026-10-31
 * Language: java
 * Date: 2026-10-31
 */

class Solution {
    public int uniquePaths(int[][] grid) {
        int mod = 1_000_000_007;
        long[] DP = new long[grid[0].length + 1];
        long[] DP1 = new long[grid[0].length + 1];
        DP1[1] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    DP[j + 1] = DP1[j + 1] = (DP[j] + DP1[j + 1]) % mod;
                } else {
                    DP[j + 1] = DP1[j + 1];
                    DP1[j + 1] = DP[j];
                }
            }
        }
        return (int) (DP[grid[0].length] % mod);
    }
}
