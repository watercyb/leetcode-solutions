/*
 * Problem: 3142. Check if Grid Satisfies Conditions
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-grid-satisfies-conditions/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i < grid.length - 1 && grid[i][j] != grid[i + 1][j])
                    return false;
                if (j < grid[0].length - 1 && grid[i][j] == grid[i][j + 1])
                    return false;
            }
        }
        return true;
    }
}
