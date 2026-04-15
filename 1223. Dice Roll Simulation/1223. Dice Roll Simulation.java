/*
 * Problem: 1223. Dice Roll Simulation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/dice-roll-simulation/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = 1_000_000_007;
        long[][] DP = new long[6][];
        for (int i = 0; i < 6; i++) {
            DP[i] = new long[rollMax[i]];
            DP[i][0] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            long[] sums = new long[6];
            long total = 0;
            for (int j = 0; j < 6; j++) {
                long sum = DP[j][0];
                for (int k = DP[j].length - 1; k >= 1; k--) {
                    sum += DP[j][k];
                    DP[j][k] = DP[j][k - 1];
                }
                sums[j] = sum;
                total += sum;
            }
            for (int j = 0; j < 6; j++) {
                DP[j][0] = (total - sums[j]) % mod;
            }
        }
        long res = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < DP[i].length; j++) {
                res += DP[i][j];
            }
        }
        return (int) (res % mod);
    }
}
