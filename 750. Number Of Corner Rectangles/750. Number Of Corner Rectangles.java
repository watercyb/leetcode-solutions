/*
 * Problem: 750. Number Of Corner Rectangles
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-corner-rectangles/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int[][] lists = new int[grid.length][grid[0].length];
        int[] idx = new int[grid.length];
        int[][] counts = new int[grid[0].length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < idx[i]; k++) {
                        res += counts[lists[i][k]][j];
                        counts[lists[i][k]][j]++;
                    }
                    lists[i][idx[i]++] = j;
                }
            }
        }
        return res;
    }
}
