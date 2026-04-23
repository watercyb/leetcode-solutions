/*
 * Problem: 2088. Count Fertile Pyramids in a Land
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-fertile-pyramids-in-a-land/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int countPyramids(int[][] grid) {
        int res = 0;
        int[][] grid1 = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            grid1[i] = grid[i].clone();
        }
        for (int i = 1; i < grid1.length; i++) {
            for (int j = 1; j < grid1[0].length - 1; j++) {
                if (grid1[i][j] == 1) {
                    int min = Math.min(Math.min(grid1[i - 1][j - 1], grid1[i - 1][j]), grid1[i - 1][j + 1]);
                    res += min;
                    grid1[i][j] = min + 1;
                }
            }
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) {
                    int min = Math.min(Math.min(grid[i + 1][j - 1], grid[i + 1][j]), grid[i + 1][j + 1]);
                    res += min;
                    grid[i][j] = min + 1;
                }
            }
        }
        return res;
    }
}
