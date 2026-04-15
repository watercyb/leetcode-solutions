/*
 * Problem: 1260. Shift 2D Grid
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shift-2d-grid/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int len = grid.length * grid[0].length;
        k = (len - k % len) % len;
        int x = k / grid[0].length;
        int y = k % grid[0].length;
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res[i][j] = grid[x][y];
                if (++y == grid[0].length) {
                    if (++x == grid.length)
                        x = 0;
                    y = 0;
                }
            }
        }
        return (List) Arrays.asList(res);
    }
}
