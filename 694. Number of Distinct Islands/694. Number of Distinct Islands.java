/*
 * Problem: 694. Number of Distinct Islands
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-distinct-islands/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> HS = new HashSet<>();
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    SB.setLength(0);
                    dfs(grid, SB, i, j);
                    HS.add(SB.toString());
                }
            }
        }
        return HS.size();
    }

    public void dfs(int[][] grid, StringBuilder SB, int i, int j) {
        grid[i][j] = 0;
        if (i > 0 && grid[i - 1][j] == 1) {
            SB.append(1);
            dfs(grid, SB, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            SB.append(2);
            dfs(grid, SB, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            SB.append(3);
            dfs(grid, SB, i, j - 1);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            SB.append(4);
            dfs(grid, SB, i, j + 1);
        }
        SB.append(0);
    }
}
