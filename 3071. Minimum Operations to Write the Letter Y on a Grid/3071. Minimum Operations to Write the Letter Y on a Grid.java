/*
 * Problem: 3071. Minimum Operations to Write the Letter Y on a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int[] countsOutside = new int[3];
        int[] countsY = new int[3];
        int x = grid.length / 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i <= x && (i == j || i + j == grid.length - 1)) || (j == x && i > x)) {
                    countsY[grid[i][j]]++;
                } else {
                    countsOutside[grid[i][j]]++;
                }
            }
        }
        int total = grid.length * grid[0].length;
        int a = total - countsY[0] - Math.max(countsOutside[1], countsOutside[2]);
        int b = total - countsY[1] - Math.max(countsOutside[0], countsOutside[2]);
        int c = total - countsY[2] - Math.max(countsOutside[0], countsOutside[1]);
        return Math.min(Math.min(a, b), c);
    }
}
