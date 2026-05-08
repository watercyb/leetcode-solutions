/*
 * Problem: 3565. Sequential Grid Path Cover
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sequential-grid-path-cover/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public List<List<Integer>> findPath(int[][] grid, int k) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] <= 1 && dfs(grid, i, j, 1, grid.length * grid[0].length))
                    return res;
            }
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public boolean dfs(int[][] grid, int i, int j, int target, int n) {
        if (n == 1) {
            res.add(List.of(i, j));
            return true;
        }
        if (grid[i][j] == target)
            target++;
        int temp = grid[i][j];
        grid[i][j] = Integer.MAX_VALUE;
        if (i > 0 && grid[i - 1][j] <= target && dfs(grid, i - 1, j, target, n - 1)) {
            res.addFirst(List.of(i, j));
            return true;
        }
        if (i < grid.length - 1 && grid[i + 1][j] <= target && dfs(grid, i + 1, j, target, n - 1)) {
            res.addFirst(List.of(i, j));
            return true;
        }
        if (j > 0 && grid[i][j - 1] <= target && dfs(grid, i, j - 1, target, n - 1)) {
            res.addFirst(List.of(i, j));
            return true;
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] <= target && dfs(grid, i, j + 1, target, n - 1)) {
            res.addFirst(List.of(i, j));
            return true;
        }
        grid[i][j] = temp;
        return false;
    }
}
