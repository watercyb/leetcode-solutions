/*
 * Problem: 892. Surface Area of 3D Shapes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/surface-area-of-3d-shapes/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int surfaceArea(int[][] grid) {
        int rl = grid.length - 1;
        int cl = grid[0].length - 1;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    res += 4 * grid[i][j] + 2;
                    if (i < rl)
                        res -= 2 * Math.min(grid[i + 1][j], grid[i][j]);
                    if (j < cl)
                        res -= 2 * Math.min(grid[i][j], grid[i][j + 1]);
                }
            }
        }
        return res;
    }
}
