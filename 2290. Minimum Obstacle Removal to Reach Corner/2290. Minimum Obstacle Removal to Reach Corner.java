/*
 * Problem: 2290. Minimum Obstacle Removal to Reach Corner
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumObstacles(int[][] grid) {
        int[][] Dq = new int[2 * grid.length * grid[0].length][];
        int l = grid.length * grid[0].length;
        int r = l + 1;
        Dq[l] = new int[] { 0, 0, 0 };
        grid[0][0] = 2;
        while (l < r) {
            int[] current = Dq[l++];
            if (current[1] == grid.length - 1 && current[2] == grid[0].length - 1)
                return current[0];
            for (int[] dir : dirs) {
                int x = current[1] + dir[0];
                int y = current[2] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 2) {
                    if (grid[x][y] == 1) {
                        Dq[r++] = new int[] { current[0] + 1, x, y };
                    } else {
                        Dq[--l] = new int[] { current[0], x, y };
                    }
                    grid[x][y] = 2;
                }
            }
        }
        return -1;
    }
}
