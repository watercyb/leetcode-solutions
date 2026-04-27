/*
 * Problem: 2482. Difference Between Ones and Zeros in Row and Column
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] r = new int[grid.length];
        int[] c = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                r[i] += grid[i][j];
                c[j] += grid[i][j];
            }
        }
        int sum = grid.length + grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 2 * (r[i] + c[j]) - sum;
            }
        }
        return grid;
    }
}
