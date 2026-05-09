/*
 * Problem: 3643. Flip Square Submatrix Vertically
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/flip-square-submatrix-vertically/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int l = x;
        int r = x + k - 1;
        while (l < r) {
            for (int i = y; i < y + k; i++) {
                int temp = grid[l][i];
                grid[l][i] = grid[r][i];
                grid[r][i] = temp;
            }
            l++;
            r--;
        }
        return grid;
    }
}
