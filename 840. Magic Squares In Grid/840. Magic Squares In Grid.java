/*
 * Problem: 840. Magic Squares In Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/magic-squares-in-grid/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (chk(grid, i, j))
                    res++;
            }
        }
        return res;
    }

    public boolean chk(int[][] grid, int i, int j) {
        boolean[] seens = new boolean[10];
        for (int k = i; k < i + 3; k++) {
            int sum = 0;
            for (int l = j; l < j + 3; l++) {
                if (grid[k][l] > 9 || seens[grid[k][l]])
                    return false;
                seens[grid[k][l]] = true;
                sum += grid[k][l];
            }
            if (sum != 15)
                return false;
        }
        for (int l = j; l < j + 3; l++) {
            int sum = 0;
            for (int k = i; k < i + 3; k++) {
                sum += grid[k][l];
            }
            if (sum != 15)
                return false;
        }
        if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15
                || grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2] != 15)
            return false;
        return true;
    }
}
