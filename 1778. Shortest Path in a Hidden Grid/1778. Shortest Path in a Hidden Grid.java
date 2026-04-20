/*
 * Problem: 1778. Shortest Path in a Hidden Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-path-in-a-hidden-grid/
 * Language: java
 * Date: 2026-04-20
 */

/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 * boolean canMove(char direction);
 * void move(char direction);
 * boolean isTarget();
 * }
 */

class Solution {
    public int findShortestPath(GridMaster master) {
        int[][] grid = new int[1002][1002];
        dfs(master, grid, 500, 500);
        if (target == null)
            return -1;
        Queue<int[]> Qu = new LinkedList<>();
        grid[500][500] = 0;
        Qu.offer(new int[] { 500, 500 });
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = Qu.poll();
                for (int[] direction : directionsXY) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];
                    if (x == target[0] && y == target[1])
                        return stp;
                    if (grid[x][y] != 0) {
                        grid[x][y] = 0;
                        Qu.offer(new int[] { x, y });
                    }
                }
            }
            stp++;
        }
        return -1;
    }

    char[] directionsChr = { 'U', 'D', 'L', 'R' };
    int[][] directionsXY = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int[] target = new int[2];

    public void dfs(GridMaster master, int[][] grid, int i, int j) {
        grid[i][j] = Integer.MAX_VALUE;
        if (master.isTarget())
            target = new int[] { i, j };
        for (int k = 0; k < 4; k++) {
            int x = i + directionsXY[k][0];
            int y = j + directionsXY[k][1];
            if (master.canMove(directionsChr[k]) && grid[x][y] == 0) {
                master.move(directionsChr[k]);
                dfs(master, grid, x, y);
                master.move(directionsChr[k ^ 1]);
            }
        }
    }
}
