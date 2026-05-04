/*
 * Problem: 3195. Find the Minimum Area to Cover All Ones I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumArea(int[][] grid) {
        int a = Integer.MAX_VALUE;
        int b = 0;
        int c = Integer.MAX_VALUE;
        int d = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    a = Math.min(a, i);
                    b = Math.max(b, i);
                    c = Math.min(c, j);
                    d = Math.max(d, j);
                }
            }
        }
        if (a == Integer.MAX_VALUE)
            return 0;
        return (b - a + 1) * (d - c + 1);
    }
}
