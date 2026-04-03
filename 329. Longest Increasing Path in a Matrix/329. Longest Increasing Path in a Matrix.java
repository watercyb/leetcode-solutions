/*
 * Problem: 329. Longest Increasing Path in a Matrix
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int[][] mems = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res=Math.max(dfs(mems,matrix,i,j),res);
            }
        }
        return res;
    }

    public int dfs(int[][] mems, int[][] matrix, int i, int j) {
        if (mems[i][j] > 0)
            return mems[i][j];
        int res = 0;
        if (i > 0 && matrix[i - 1][j] < matrix[i][j])
            res = Math.max(dfs(mems, matrix, i - 1, j), res);
        if (i < matrix.length - 1 && matrix[i + 1][j] < matrix[i][j])
            res = Math.max(dfs(mems, matrix, i + 1, j), res);
        if (j > 0 && matrix[i][j - 1] < matrix[i][j])
            res = Math.max(dfs(mems, matrix, i, j - 1), res);
        if (j < matrix[0].length - 1 && matrix[i][j + 1] < matrix[i][j])
            res = Math.max(dfs(mems, matrix, i, j + 1), res);
        mems[i][j] = res + 1;
        return mems[i][j];
    }
}
