/*
 * Problem: 1810. Minimum Path Cost in a Hidden Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-path-cost-in-a-hidden-grid/
 * Language: java
 * Date: 2026-04-21
 */

/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 * boolean canMove(char direction);
 * int move(char direction);
 * boolean isTarget();
 * }
 */

class Solution {
    public int findShortestPath(GridMaster master) {
        int[][] grid = new int[201][201];
        dfs(master, grid, 100, 100);
        if (target == null)
            return -1;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        PQ.offer(new int[] { 100, 100, 0 });
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            if (current[0] == target[0] && current[1] == target[1])
                return current[2];
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (grid[x][y] == -1)
                    continue;
                PQ.offer(new int[] { x, y, current[2] + grid[x][y] });
                grid[x][y] = -1;
            }
        }
        return -1;
    }

    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    char[] chrs = { 'D', 'U', 'R', 'L' };
    int[] target;

    public void dfs(GridMaster master, int[][] grid, int x, int y) {
        if (master.isTarget())
            target = new int[] { x, y };
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < 4; i++) {
            int xNext = x + directions[i][0];
            int yNext = y + directions[i][1];
            if (grid[xNext][yNext] == 0) {
                grid[xNext][yNext] = master.move(chrs[i]);
                if (grid[xNext][yNext] != -1) {
                    dfs(master, grid, xNext, yNext);
                    master.move(chrs[i ^ 1]);
                }
            }
        }
    }
}
