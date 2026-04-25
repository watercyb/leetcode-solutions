/*
 * Problem: 2257. Count Unguarded Cells in the Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grids = new int[m][n];
        int res = m * n - guards.length - walls.length;
        for (int[] wall : walls) {
            grids[wall[0]][wall[1]] = 1;
        }
        for (int[] guard : guards) {
            grids[guard[0]][guard[1]] = 1;
        }
        for (int[] guard : guards) {
            for (int i = guard[1] + 1; i < n && grids[guard[0]][i] != 1; i++) {
                if (grids[guard[0]][i] != -1) {
                    grids[guard[0]][i] = -1;
                    res--;
                }
            }
            for (int i = guard[1] - 1; i >= 0 && grids[guard[0]][i] != 1; i--) {
                if (grids[guard[0]][i] != -1) {
                    grids[guard[0]][i] = -1;
                    res--;
                }
            }
            for (int i = guard[0] + 1; i < m && grids[i][guard[1]] != 1; i++) {
                if (grids[i][guard[1]] != -1) {
                    grids[i][guard[1]] = -1;
                    res--;
                }
            }
            for (int i = guard[0] - 1; i >= 0 && grids[i][guard[1]] != 1; i--) {
                if (grids[i][guard[1]] != -1) {
                    grids[i][guard[1]] = -1;
                    res--;
                }
            }
        }
        return res;
    }
}
