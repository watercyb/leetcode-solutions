/*
 * Problem: 3193. Count the Number of Inversions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-inversions/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int mod = 1_000_000_007;
        int max = 0;
        int[] limits = new int[n];
        Arrays.fill(limits, -1);
        for (int[] requirement : requirements) {
            max = Math.max(requirement[1], max);
            limits[requirement[0]] = requirement[1];
        }
        if (limits[0] > 0)
            return 0;
        long[][] DP = new long[n][max + 1];
        DP[0][0] = 1;
        int lim = 1;
        for (int i = 1; i < n; i++) {
            if (limits[i] >= 0) {
                long sum = 0;
                for (int j = Math.max(limits[i] - i, 0); j <= limits[i]; j++) {
                    sum += DP[i - 1][j];
                }
                DP[i][limits[i]] = sum % mod;
            } else {
                long sum = 0;
                for (int j = 0; j <= Math.min(limits[n - 1], lim); j++) {
                    sum += DP[i - 1][j];
                    if (j > i)
                        sum -= DP[i - 1][j - i - 1];
                    sum = (sum + mod) % mod;
                    DP[i][j] = sum;
                }
            }
            lim += i + 1;
        }
        return (int) DP[n - 1][limits[n - 1]];
    }
}
