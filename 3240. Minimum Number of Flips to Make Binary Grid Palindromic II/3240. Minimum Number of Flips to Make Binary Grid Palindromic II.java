/*
 * Problem: 3240. Minimum Number of Flips to Make Binary Grid Palindromic II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minFlips(int[][] grid) {
        int res = 0;
        boolean changed = false;
        int limX = grid.length / 2;
        int limY = grid[0].length / 2;
        for (int i = 0; i < limX; i++) {
            int i1 = grid.length - 1 - i;
            for (int j = 0; j < limY; j++) {
                int j1 = grid[0].length - 1 - j;
                int count = (grid[i][j] + grid[i1][j] + grid[i][j1] + grid[i1][j1]) % 4;
                if (count == 3)
                    count -= 2;
                res += count;
            }
        }
        int count = 0;
        if (grid.length % 2 == 1 && grid[0].length % 2 == 1)
            res += grid[limX][limY];
        if (grid.length % 2 == 1) {
            for (int i = 0; i < limY; i++) {
                int i1 = grid[0].length - 1 - i;
                if (grid[limX][i] != grid[limX][i1]) {
                    res++;
                    changed = true;
                }
                count += grid[limX][i] + grid[limX][i1];
            }
        }
        if (grid[0].length % 2 == 1) {
            for (int i = 0; i < limX; i++) {
                int i1 = grid.length - 1 - i;
                if (grid[i][limY] != grid[i1][limY]) {
                    res++;
                    changed = true;
                }
                count += grid[i][limY] + grid[i1][limY];
            }
        }
        if (count % 4 == 2 && !changed)
            res += 2;
        return res;
    }
}
