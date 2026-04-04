/*
 * Problem: 576. Out of Boundary Paths
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/out-of-boundary-paths/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] mems = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(mems[i][j], -1);
            }
        }
        return dfs(mems, m, n, maxMove, startRow, startColumn);
    }

    int mod = 1000000007;

    public int dfs(int[][][] mems, int m, int n, int move, int r, int c) {
        if (r < 0 || r == m || c < 0 || c == n)
            return 1;
        if (move == 0)
            return 0;
        if (mems[r][c][move] != -1)
            return mems[r][c][move];
        mems[r][c][move] = 0;
        mems[r][c][move] = (mems[r][c][move] + dfs(mems, m, n, move - 1, r + 1, c)) % mod;
        mems[r][c][move] = (mems[r][c][move] + dfs(mems, m, n, move - 1, r - 1, c)) % mod;
        mems[r][c][move] = (mems[r][c][move] + dfs(mems, m, n, move - 1, r, c + 1)) % mod;
        mems[r][c][move] = (mems[r][c][move] + dfs(mems, m, n, move - 1, r, c - 1)) % mod;
        return mems[r][c][move];
    }
}
