/*
 * Problem: 1230. Toss Strange Coins
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/toss-strange-coins/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] DP = new double[target + 1];
        DP[0] = 1;
        for (int i = 0; i < prob.length; i++) {
            DP[target] *= 1 - prob[i];
            for (int j = target - 1; j >= 0; j--) {
                DP[j + 1] += DP[j] * prob[i];
                DP[j] *= 1 - prob[i];
            }
        }
        return DP[target];
    }
}
