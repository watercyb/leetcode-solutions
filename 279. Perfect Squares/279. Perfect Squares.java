/*
 * Problem: 279. Perfect Squares
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/perfect-squares/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    static int[] DP;

    public int numSquares(int n) {
        if (DP == null) {
            DP = new int[10001];
            for (int i = 1; i <= 10000; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, DP[i - j * j] + 1);
                }
                DP[i] = min;
            }
        }
        return DP[n];
    }
}
