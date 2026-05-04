/*
 * Problem: 3129. Find All Possible Stable Binary Arrays I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1_000_000_007;
        long[][][] DP = new long[zero + 1][one + 1][2];
        for (int i = 0; i <= Math.min(zero, limit); i++) {
            DP[i][0][0] = 1;
        }
        for (int i = 0; i <= Math.min(one, limit); i++) {
            DP[0][i][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                DP[i][j][1] = (DP[i][j - 1][1] + DP[i][j - 1][0]) % mod;
                if (j - limit - 1 >= 0)
                    DP[i][j][1] = (DP[i][j][1] - DP[i][j - limit - 1][0] + mod) % mod;
                DP[i][j][0] = (DP[i - 1][j][0] + DP[i - 1][j][1]) % mod;
                if (i - limit - 1 >= 0)
                    DP[i][j][0] = (DP[i][j][0] - DP[i - limit - 1][j][1] + mod) % mod;
            }
        }
        return (int) ((DP[zero][one][0] + DP[zero][one][1]) % mod);
    }
}

