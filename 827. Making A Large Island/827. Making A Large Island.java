/*
 * Problem: 827. Making A Large Island
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/making-a-large-island/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int largestIsland(int[][] grid) {
        List<Integer> counts = new ArrayList<>();
        counts.add(0);
        counts.add(0);
        int n = 2;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j, n);
                    res = Math.max(count, res);
                    counts.add(count);
                    n++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int[] neighbors = new int[4];
                    int count = 1;
                    if (i > 0 && grid[i - 1][j] != 0)
                        neighbors[0] = grid[i - 1][j];
                    if (i < grid.length - 1)
                        neighbors[1] = grid[i + 1][j];
                    if (j > 0)
                        neighbors[2] = grid[i][j - 1];
                    if (j < grid[0].length - 1)
                        neighbors[3] = grid[i][j + 1];
                    count += counts.get(neighbors[0]);
                    if (neighbors[1] != neighbors[0])
                        count += counts.get(neighbors[1]);
                    if (neighbors[2] != neighbors[1] && neighbors[2] != neighbors[0])
                        count += counts.get(neighbors[2]);
                    if (neighbors[3] != neighbors[2] && neighbors[3] != neighbors[1] && neighbors[3] != neighbors[0])
                        count += counts.get(neighbors[3]);
                    res = Math.max(count, res);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j, int n) {
        grid[i][j] = n;
        int res = 1;
        if (i > 0 && grid[i - 1][j] == 1)
            res += dfs(grid, i - 1, j, n);
        if (i < grid.length - 1 && grid[i + 1][j] == 1)
            res += dfs(grid, i + 1, j, n);
        if (j > 0 && grid[i][j - 1] == 1)
            res += dfs(grid, i, j - 1, n);
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
            res += dfs(grid, i, j + 1, n);
        return res;
    }
}
