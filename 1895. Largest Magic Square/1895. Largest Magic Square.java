/*
 * Problem: 1895. Largest Magic Square
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-magic-square/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int largestMagicSquare(int[][] grid) {
        int[][] rows = new int[grid.length][grid[0].length + 1];
        int[][] cols = new int[grid[0].length][grid.length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rows[i][j + 1] = grid[i][j] + rows[i][j];
                cols[j][i + 1] = grid[i][j] + cols[j][i];
            }
        }
        int lim = Math.min(grid.length, grid[0].length);
        for (int i = lim; i >= 2; i--) {
            for (int j = 0; j <= grid.length - i; j++) {
                for (int k = 0; k <= grid[0].length - i; k++) {
                    if (chk(grid, rows, cols, j, k, i))
                        return i;
                }
            }
        }
        return 1;
    }

    public boolean chk(int[][] grid, int[][] rows, int[][] cols, int x, int y, int l) {
        int a = 0;
        int b = 0;
        int target = rows[x][y + l] - rows[x][y];
        for (int i = 0; i < l; i++) {
            a += grid[x + i][y + i];
            b += grid[x + i][y + l - 1 - i];
            if (rows[x + i][y + l] - rows[x + i][y] != target || cols[y + i][x + l] - cols[y + i][x] != target)
                return false;
        }
        return a == b && a == target;
    }
}
