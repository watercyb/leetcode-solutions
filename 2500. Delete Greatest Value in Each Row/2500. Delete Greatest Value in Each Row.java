/*
 * Problem: 2500. Delete Greatest Value in Each Row
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/delete-greatest-value-in-each-row/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                if (max<grid[j][i])
                max = grid[j][i];
            }
            res += max;
        }
        return res;
    }
}
