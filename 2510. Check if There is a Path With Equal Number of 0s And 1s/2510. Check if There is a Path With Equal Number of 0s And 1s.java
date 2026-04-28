/*
 * Problem: 2510. Check if There is a Path With Equal Number of 0's And 1's
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-there-is-a-path-with-equal-number-of-0s-and-1s/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public boolean isThereAPath(int[][] grid) {
        int n = grid.length + grid[0].length - 1;
        if (n % 2 == 1)
            return false;
        n /= 2;
        long mod = 1l << 100;
        long[] DP = new long[grid[0].length + 1];
        DP[1] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    DP[j + 1] = ((DP[j + 1] << 1) | (DP[j] << 1)) % mod;
                } else {
                    DP[j + 1] = DP[j + 1] | DP[j];
                }
            }
        }
        return (DP[grid[0].length] & (1l << n)) != 0;
    }
}
