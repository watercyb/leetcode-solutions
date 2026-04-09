/*
 * Problem: 883. Projection Area of 3D Shapes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/projection-area-of-3d-shapes/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int projectionArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (max < grid[i][j])
                    max = grid[i][j];
                if (grid[i][j] > 0)
                    res++;
            }
            res += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                if (max < grid[j][i])
                    max = grid[j][i];
            }
            res += max;
        }
        return res;
    }
}
