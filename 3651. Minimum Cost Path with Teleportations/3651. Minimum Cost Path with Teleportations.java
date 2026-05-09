/*
 * Problem: 3651. Minimum Cost Path with Teleportations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-path-with-teleportations/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minCost(int[][] grid, int k) {
        int[][] steps = new int[grid.length + 1][grid[0].length + 1];
        for (int[] row : steps) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        steps[1][1] = 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(grid[i][j], max);
            }
        }
        int[] mins = new int[max + 1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        while (k >= 0) {
            mins = getStps(grid, steps, mins);
            k--;
        }
        return steps[grid.length][grid[0].length];
    }

    public int[] getStps(int[][] grid, int[][] steps, int[] mins) {
        int[] res = mins.clone();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                steps[i + 1][j + 1] = Math.min(Math.min(steps[i][j + 1], steps[i + 1][j]) + grid[i][j],
                        Math.min(steps[i + 1][j + 1], mins[grid[i][j]]));
                res[grid[i][j]] = Math.min(steps[i + 1][j + 1], res[grid[i][j]]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = res.length - 1; i >= 0; i--) {
            min = res[i] = Math.min(res[i], min);
        }
        return res;
    }
}
