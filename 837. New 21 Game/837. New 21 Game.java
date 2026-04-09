/*
 * Problem: 837. New 21 Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/new-21-game/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0)
            return 1;
        double res = 0;
        double[] DP = new double[n + 1];
        DP[0] = 1.0;
        double sum = 1.0;
        for (int i = 1; i <= n; i++) {
            double p = sum / maxPts;
            if (i < k) {
                DP[i] = p;
                sum += p;
            } else {
                res += p;
            }
            if (i >= maxPts)
                sum -= DP[i - maxPts];
        }
        return res;
    }
}
