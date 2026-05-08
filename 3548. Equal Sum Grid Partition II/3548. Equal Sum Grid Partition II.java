/*
 * Problem: 3548. Equal Sum Grid Partition II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/equal-sum-grid-partition-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
                max = Math.max(grid[i][j], max);
            }
        }
        long target = sum;
        sum = 0;
        boolean[] seens = new boolean[max + 1];
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
                seens[grid[i][j]] = true;
            }
            long diff = 2 * sum - target;
            if (diff == 0)
                return true;
            if (diff > max)
                break;
            if (diff > 0) {
                if (i == 0) {
                    if (grid[0][0] == diff || grid[0][grid[0].length - 1] == diff)
                        return true;
                } else if (grid[0].length == 1) {
                    if (grid[0][0] == diff || grid[i][0] == diff)
                        return true;
                } else {
                    if (seens[(int) diff])
                        return true;
                }
            }
        }

        sum = 0;
        seens = new boolean[max + 1];
        for (int i = grid.length - 1; i > 0; i--) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
                seens[grid[i][j]] = true;
            }
            long diff = 2 * sum - target;
            if (diff == 0)
                return true;
            if (diff > max)
                break;
            if (diff > 0 && diff <= max) {
                if (i == grid.length - 1) {
                    if (grid[grid.length - 1][0] == diff || grid[grid.length - 1][grid[0].length - 1] == diff)
                        return true;
                } else if (grid[0].length == 1) {
                    if (grid[grid.length - 1][0] == diff || grid[i][0] == diff)
                        return true;
                } else {
                    if (seens[(int) diff])
                        return true;
                }
            }
        }

        sum = 0;
        seens = new boolean[max + 1];
        for (int j = 0; j < grid[0].length - 1; j++) {
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][j];
                seens[grid[i][j]] = true;
            }
            long diff = 2 * sum - target;
            if (diff == 0)
                return true;
            if (diff > max)
                break;
            if (diff > 0 && diff <= max) {
                if (j == 0) {
                    if (grid[0][0] == diff || grid[grid.length - 1][0] == diff)
                        return true;
                } else if (grid.length == 1) {
                    if (grid[0][0] == diff || grid[0][j] == diff)
                        return true;
                } else {
                    if (seens[(int) diff])
                        return true;
                }
            }
        }

        sum = 0;
        seens = new boolean[max + 1];
        for (int j = grid[0].length - 1; j > 0; j--) {
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][j];
                seens[grid[i][j]] = true;
            }
            long diff = 2 * sum - target;
            if (diff == 0)
                return true;
            if (diff > max)
                break;
            if (diff > 0 && diff <= max) {
                if (j == grid[0].length - 1) {
                    if (grid[0][grid[0].length - 1] == diff || grid[grid.length - 1][grid[0].length - 1] == diff)
                        return true;
                } else if (grid.length == 1) {
                    if (grid[0][grid[0].length - 1] == diff || grid[0][j] == diff)
                        return true;
                } else {
                    if (seens[(int) diff])
                        return true;
                }
            }
        }
        return false;
    }
}
