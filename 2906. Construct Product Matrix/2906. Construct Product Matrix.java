/*
 * Problem: 2906. Construct Product Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-product-matrix/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int pro = 1;
        int[][] lefts = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = grid[i][j] % mod;
                lefts[i][j] = pro;
                pro = pro * grid[i][j] % mod;
            }
        }
        pro = 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                int proNext = pro * grid[i][j] % mod;
                grid[i][j] = lefts[i][j] * pro % mod;
                pro = proNext;
            }
        }
        return grid;
    }
}
