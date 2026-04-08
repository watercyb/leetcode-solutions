/*
 * Problem: 799. Champagne Tower
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/champagne-tower/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] DP = new double[query_row + 1][query_row + 1];
        DP[0][0] = (double) poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j < i; j++) {
                if (DP[i-1][j] < 1) continue;
                double tmp = (DP[i-1][j] - 1) / 2;
                DP[i][j] += tmp;
                DP[i][j + 1] += tmp;
            }
        }
        return DP[query_row][query_glass] > 1 ? 1 : DP[query_row][query_glass];
    }
}
