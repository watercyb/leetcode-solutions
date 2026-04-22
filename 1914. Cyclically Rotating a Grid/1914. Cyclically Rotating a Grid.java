/*
 * Problem: 1914. Cyclically Rotating a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/cyclically-rotating-a-grid/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int x = 0;
        int y = 0;
        while (x < grid.length / 2 && y < grid[0].length / 2) {
            r(grid, x, y, k);
            x++;
            y++;
        }
        return grid;
    }

    public void r(int[][] grid, int x, int y, int k) {
        int n = (grid.length - 2 * x + grid[0].length - 2 * y - 2) * 2;
        if ((n - k % n) % n == 0)
            return;
        int[] arr = new int[2 * n];
        int idx = 0;
        for (int i = x + 1; i < grid.length - x; i++) {
            arr[idx] = arr[idx + n] = grid[i][y];
            idx++;
        }
        for (int i = y + 1; i < grid[0].length - y; i++) {
            arr[idx] = arr[idx + n] = grid[grid.length - 1 - x][i];
            idx++;
        }
        for (int i = grid.length - x - 2; i >= x; i--) {
            arr[idx] = arr[idx + n] = grid[i][grid[0].length - 1 - y];
            idx++;
        }
        for (int i = grid[0].length - y - 2; i >= y; i--) {
            arr[idx] = arr[idx + n] = grid[x][i];
            idx++;
        }
        idx = (n - k % n) % n;
        for (int i = x + 1; i < grid.length - x; i++) {
            grid[i][y] = arr[idx++];
        }
        for (int i = y + 1; i < grid[0].length - y; i++) {
            grid[grid.length - 1 - x][i] = arr[idx++];
        }
        for (int i = grid.length - x - 2; i >= x; i--) {
            grid[i][grid[0].length - 1 - y] = arr[idx++];
        }
        for (int i = grid[0].length - y - 2; i >= y; i--) {
            grid[x][i] = arr[idx++];
        }
    }
}
