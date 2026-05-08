/*
 * Problem: 3546. Equal Sum Grid Partition I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/equal-sum-grid-partition-i/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
        }
        if (sum % 2 == 1)
            return false;
        long target = sum / 2;
        sum = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
            if (sum == target)
                return true;
            if (sum > target)
                break;
        }
        sum = 0;
        for (int j = 0; j < grid[0].length - 1; j++) {
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][j];
            }
            if (sum == target)
                return true;
            if (sum > target)
                break;
        }
        return false;
    }
}
