/*
 * Problem: 361. Bomb Enemy
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bomb-enemy/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int[][] counts = new int[grid.length][grid[0].length];
        int[] cols = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    sum++;
                    cols[j]++;
                } else if (grid[i][j] == 'W') {
                    sum = 0;
                    cols[j] = 0;
                } else {
                    counts[i][j] = sum + cols[j];
                }
            }
        }
        int res = 0;
        Arrays.fill(cols, 0);
        for (int i = grid.length - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                    sum++;
                    cols[j]++;
                } else if (grid[i][j] == 'W') {
                    sum = 0;
                    cols[j] = 0;
                } else {
                    res = Math.max(counts[i][j] + sum + cols[j], res);
                }
            }
        }
        return res;
    }
}
