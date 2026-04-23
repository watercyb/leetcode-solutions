/*
 * Problem: 2017. Grid Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/grid-game/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public long gridGame(int[][] grid) {
        long sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            sum += grid[0][i];
        }
        long res = Long.MAX_VALUE;
        long sum1 = 0;
        for (int i = 0; i < grid[0].length; i++) {
            sum -= grid[0][i];
            res = Math.min(Math.max(sum, sum1), res);
            sum1 += grid[1][i];
        }
        return res;
    }
}
