/*
 * Problem: 1162. As Far from Land as Possible
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/as-far-from-land-as-possible/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> Qu = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Qu.add(new int[] { i, j });
                }
            }
        }
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int[] stp={-1,-1};
        while (!Qu.isEmpty()) {
            stp = Qu.poll();
            for (int[] dir : dirs) {
                int x = stp[0] + dir[0];
                int y = stp[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
                    grid[x][y] = grid[stp[0]][stp[1]] + 1;
                    Qu.add(new int[] { x, y });
                }
            }
        }
        if (stp[0]==-1||grid[stp[0]][stp[1]] == 1)
            return -1;
        return grid[stp[0]][stp[1]] - 1;
    }
}
