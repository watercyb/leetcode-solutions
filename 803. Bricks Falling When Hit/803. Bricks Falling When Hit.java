/*
 * Problem: 803. Bricks Falling When Hit
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/bricks-falling-when-hit/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[][] newGrid = new int[grid.length + 3][grid[0].length + 2];
        for (int i = 1; i <= grid[0].length; i++) {
            newGrid[1][i] = 1;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newGrid[i + 2][j + 1] = grid[i][j];
            }
        }
        for (int[] hit : hits) {
            newGrid[hit[0] + 2][hit[1] + 1] = 0;
        }
        boolean[][] seens = new boolean[newGrid.length][newGrid[0].length];
        dfs(newGrid, seens, 1, 1);
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            if (grid[hits[i][0]][hits[i][1]] == 0)
                continue;
            int x = hits[i][0] + 2;
            int y = hits[i][1] + 1;
            newGrid[x][y] = 1;
            if (seens[x - 1][y] || seens[x + 1][y] || seens[x][y - 1] || seens[x][y + 1])
                res[i] = dfs(newGrid, seens, x, y) - 1;
        }
        return res;
    }

    boolean isConnected = false;

    public int dfs(int[][] newGrid, boolean[][] seens, int x, int y) {
        seens[x][y] = true;
        int res = 1;
        if (newGrid[x - 1][y] == 1 && !seens[x - 1][y])
            res += dfs(newGrid, seens, x - 1, y);
        if (newGrid[x + 1][y] == 1 && !seens[x + 1][y])
            res += dfs(newGrid, seens, x + 1, y);
        if (newGrid[x][y - 1] == 1 && !seens[x][y - 1])
            res += dfs(newGrid, seens, x, y - 1);
        if (newGrid[x][y + 1] == 1 && !seens[x][y + 1])
            res += dfs(newGrid, seens, x, y + 1);
        return res;
    }
}
