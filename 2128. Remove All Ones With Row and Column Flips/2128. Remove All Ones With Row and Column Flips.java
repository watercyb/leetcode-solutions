/*
 * Problem: 2128. Remove All Ones With Row and Column Flips
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public boolean removeOnes(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((grid[0][0] ^ grid[i][0] ^ grid[0][j] ^ grid[i][j]) == 1)
                    return false;
            }
        }
        return true;
    }
}
