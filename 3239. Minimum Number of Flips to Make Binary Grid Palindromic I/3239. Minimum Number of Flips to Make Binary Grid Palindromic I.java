/*
 * Problem: 3239. Minimum Number of Flips to Make Binary Grid Palindromic I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minFlips(int[][] grid) {
        int a = 0;
        int b = 0;
        for (int i = 0; i <= (grid.length - 1) / 2; i++) {
            int i1 = grid.length - 1 - i;
            for (int j = 0; j < grid[0].length; j++) {
                a += (grid[i][j] + grid[i1][j]) % 2;
            }
        }
        for (int j = 0; j <= (grid[0].length - 1) / 2; j++) {
            int j1 = grid[0].length - 1 - j;
            for (int i = 0; i < grid.length; i++) {
                b += (grid[i][j] + grid[i][j1]) % 2;
            }
        }
        return Math.min(a, b);
    }
}
