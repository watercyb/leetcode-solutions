/*
 * Problem: 2639. Find the Width of Columns of a Grid
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res[j] = Math.max(res[j], getLength(grid[i][j]));
            }
        }
        return res;
    }

    public int getLength(int num) {
        int res = num > 0 ? 0 : 1;
        num = Math.abs(num);
        while (num > 0) {
            num /= 10;
            res++;
        }
        return res;
    }
}
