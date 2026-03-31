/*
 * Problem: 296. Best Meeting Point
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/best-meeting-point/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int minTotalDistance(int[][] grid) {
        int[] sumRow = new int[grid.length];
        int[] sumCol = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sumRow[i]++;
                    sumCol[j]++;
                }
            }
        }
        int[] distCol = new int[grid.length + 2];
        int[] distRow = new int[grid[0].length + 2];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            distCol[i + 1] = distCol[i] + sum;
            sum += sumRow[i];
        }
        sum = 0;
        int tmp = 0;
        for (int i = grid.length; i > 0; i--) {
            distCol[i] += tmp + sum;
            tmp += sum;
            sum += sumRow[i - 1];
        }
        sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            distRow[i + 1] = distRow[i] + sum;
            sum += sumCol[i];
        }
        sum = 0;
        tmp = 0;
        for (int i = grid[0].length; i > 0; i--) {
            distRow[i] += tmp + sum;
            tmp += sum;
            sum += sumCol[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            res = Math.min(distCol[i + 1], res);
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            min = Math.min(distRow[j + 1], min);
        }
        return res + min;
    }
}
