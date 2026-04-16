/*
 * Problem: 1351. Count Negative Numbers in a Sorted Matrix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int countNegatives(int[][] grid) {
        int j = grid[0].length - 1;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            while (j >= 0 && grid[i][j] < 0) {
                j--;
            }
            res += grid[0].length - 1 - j;
        }
        return res;
    }
}
