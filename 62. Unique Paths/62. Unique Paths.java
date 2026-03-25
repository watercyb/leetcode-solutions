/*
 * Problem: 62. Unique Paths
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-paths/
 * Language: java
 * Date: 2026-03-25
 */

;
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] DP = new int[m][n];
        DP[0][n - 1] = 1;
        for (int i = 1; i < m; i++) {
            DP[i][n - 1] = DP[i - 1][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                DP[i][j] = DP[i - 1][j] + DP[i][j + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += DP[m - 1][i];
        }
        return res;
    }
}
