/*
 * Problem: 463. Island Perimeter
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/island-perimeter/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        res -= 2;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
                        res -= 2;
                }
            }
        }
        return res;
    }
}
