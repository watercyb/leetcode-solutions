/*
 * Problem: 3446. Sort Matrix by Diagonals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-matrix-by-diagonals/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int[] arr = new int[grid.length - i];
            int idx = 0;
            for (int j = 0; j + i < grid.length; j++) {
                arr[idx++] = grid[j + i][j];
            }
            Arrays.sort(arr);
            idx = arr.length - 1;
            for (int j = 0; j + i < grid.length; j++) {
                grid[j + i][j] = arr[idx--];
            }
        }
        for (int i = 1; i < grid[0].length; i++) {
            int[] arr = new int[grid[0].length - i];
            int idx = 0;
            for (int j = 0; j + i < grid[0].length; j++) {
                arr[idx++] = grid[j][j + i];
            }
            Arrays.sort(arr);
            idx = 0;
            for (int j = 0; j + i < grid[0].length; j++) {
                grid[j][j + i] = arr[idx++];
            }
        }
        return grid;
    }
}
