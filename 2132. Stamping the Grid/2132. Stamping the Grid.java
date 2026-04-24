/*
 * Problem: 2132. Stamping the Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/stamping-the-grid/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int[] lens = new int[grid[0].length];
        int count = grid.length * grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            int len = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    len = 0;
                    lens[j] = 0;
                    count--;
                } else {
                    len++;
                    if (len >= stampWidth) {
                        lens[j]++;
                        if (lens[j] >= stampHeight)
                            count -= fill(grid, i - stampHeight + 1, i, j - stampWidth + 1, j);
                    } else {
                        lens[j] = 0;
                    }
                }
            }
        }
        return count == 0;
    }

    public int fill(int[][] grid, int x1, int x2, int y1, int y2) {
        int res = 0;
        for (int i = y2; i >= y1; i--) {
            if (grid[x2][i] != 0)
                break;
            for (int j = x2; j >= x1; j--) {
                if (grid[j][i] == 0) {
                    grid[j][i] = 1;
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
