/*
 * Problem: 458. Poor Pigs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/poor-pigs/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie;
        if (n == 1)
            return (int) Math.ceil(Math.log(buckets) / Math.log(2));
        int l = (int) (Math.log(buckets) / Math.log(2)) + 2;
        int[][] DP = new int[n + 1][l];
        DP[1][0] = 1;
        for (int i = 1; i < l; i++) {
            DP[1][i] = DP[1][i - 1] * 2;
        }
        for (int i = 2; i <= n; i++) {
            DP[i][0] = 1;
            for (int j = 1; j < l; j++) {
                DP[i][j] = DP[i - 1][j];
                int a = j;
                int b = 1;
                for (int k = j - 1; k >= 0; k--) {
                    DP[i][j] += DP[i - 1][k] * a / b;
                    a *= k;
                    b *= (j - k + 1);
                }
                if (i == n && DP[i][j] >= buckets)
                    return j;
            }
        }
        return -1;
    }
}
