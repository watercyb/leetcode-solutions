/*
 * Problem: 1091. Shortest Path in Binary Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    int[][] dirts = { { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 0, 1 }, { 0, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;
        if (grid.length == 1 && grid[0].length == 1)
            return 1;
        Deque<int[]> Qu = new ArrayDeque<>();
        Qu.add(new int[] { 0, 0, 1 });
        while (!Qu.isEmpty()) {
            int[] tmp = Qu.poll();
            if (tmp[0] == grid.length - 1 && tmp[1] == grid[0].length - 1)
                return tmp[2];
            int stp = tmp[2] + 1;
            for (int[] dirt : dirts) {
                int x = tmp[0] + dirt[0];
                int y = tmp[1] + dirt[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
                    Qu.offer(new int[] { x, y, stp });
                    grid[x][y] = 1;
                }
            }
        }
        return -1;
    }
}
