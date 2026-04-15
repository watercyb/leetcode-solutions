/*
 * Problem: 1267. Count Servers that Communicate
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-servers-that-communicate/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1))
                    res++;
            }
        }
        return res;
    }
}
