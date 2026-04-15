/*
 * Problem: 1293. Shortest Path in a Grid with Obstacles Elimination
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {

    public int shortestPath(int[][] grid, int k) {
        int[][] stps = new int[grid.length][grid[0].length];
        Queue<int[]> Qu = new LinkedList<>();
        if (grid[0][0] == 1) {
            if (k == 0) {
                return -1;
            } else {
                k--;
            }
        }
        stps[0][0] = 1;
        Qu.add(new int[] { 0, 0 });
        int res = Integer.MAX_VALUE;
        while (!Qu.isEmpty() && k >= 0) {
            Qu = BFS(Qu, stps, grid);
            if (stps[grid.length - 1][grid[0].length - 1] > 0 && stps[grid.length - 1][grid[0].length - 1] < res)
                res = stps[grid.length - 1][grid[0].length - 1];
            k--;
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res - 1;
    }

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public Queue<int[]> BFS(Queue<int[]> Qu, int[][] stps, int[][] grid) {
        Queue<int[]> QuNext = new LinkedList<>();
        while (!Qu.isEmpty()) {
            int[] stp = Qu.poll();
            for (int[] dir : dirs) {
                int x = stp[0] + dir[0];
                int y = stp[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                        && (stps[x][y] == 0 || stps[x][y] > stps[stp[0]][stp[1]] + 1)) {
                    if (grid[x][y] == 0) {
                        stps[x][y] = stps[stp[0]][stp[1]] + 1;
                        Qu.add(new int[] { x, y });
                    } else {
                        stps[x][y] = stps[stp[0]][stp[1]] + 1;
                        QuNext.add(new int[] { x, y });
                    }
                }
            }
        }
        return QuNext;
    }
}
