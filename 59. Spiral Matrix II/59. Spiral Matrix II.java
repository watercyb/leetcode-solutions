/*
 * Problem: 59. Spiral Matrix II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/spiral-matrix-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] dirts = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] res = new int[n][n];
        int idx = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            x += dirts[idx][0];
            y += dirts[idx][1];
            if (x < 0 || x == n || y < 0 || y == n || res[x][y] != 0) {
                x -= dirts[idx][0];
                y -= dirts[idx][1];
                idx = (idx + 1) % 4;
                x += dirts[idx][0];
                y += dirts[idx][1];
            }
        }
        return res;
    }
}
