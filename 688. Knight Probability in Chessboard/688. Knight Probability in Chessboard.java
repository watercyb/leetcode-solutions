/*
 * Problem: 688. Knight Probability in Chessboard
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/knight-probability-in-chessboard/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] mems = new double[n][n][k];
        double res = dfs(mems, n, k - 1, row, column);
        return (double) res / Math.pow(8, k);
    }

    int[][] dirs = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

    public double dfs(double[][][] mems, int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n)
            return 0;
        if (k == -1)
            return 1;
        if (mems[row][column][k] != 0)
            return mems[row][column][k];
        double res = 0;
        for (int[] dir : dirs) {
            res += dfs(mems, n, k - 1, row + dir[0], column + dir[1]);
        }
        mems[row][column][k] = res;
        return res;
    }
}
