/*
 * Problem: 3797. Count Routes to Climb a Rectangular Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-routes-to-climb-a-rectangular-grid/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int numberOfRoutes(String[] grid, int d) {
        int mod = 1_000_000_007;
        char[][] chrs = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            chrs[i] = grid[i].toCharArray();
        }
        long[] DP = new long[chrs[0].length];
        for (int i = 0; i < DP.length; i++) {
            if (chrs[chrs.length - 1][i] == '.')
                DP[i] = 1;
        }
        int lim = (int) Math.sqrt(d * d - 1);
        long[] DPSum = new long[DP.length];
        for (int i = chrs.length - 1; i > 0; i--) {
            long[] DPNext = new long[DP.length];
            long sum = 0;
            char[] a = chrs[i];
            char[] b = chrs[i - 1];
            for (int j = 0; j < Math.min(d, DP.length); j++) {
                sum += DP[j];
            }
            for (int j = 0; j < DP.length; j++) {
                if (j + d < DP.length)
                    sum += DP[j + d];
                if (a[j] == '.') {
                    DPSum[j] = sum % mod;
                } else {
                    DPSum[j] = 0;
                }
                if (j >= d)
                    sum -= DP[j - d];
            }
            sum = 0;
            for (int j = 0; j < Math.min(lim, DP.length); j++) {
                sum += DPSum[j];
            }
            for (int j = 0; j < DP.length; j++) {
                if (j + lim < DP.length)
                    sum += DPSum[j + lim];
                if (b[j] == '.')
                    DPNext[j] = sum % mod;
                if (j >= lim)
                    sum -= DPSum[j - lim];
            }
            DP = DPNext;
        }
        long sum = 0;
        for (int j = 0; j < Math.min(d, DP.length); j++) {
            sum += DP[j];
        }
        for (int j = 0; j < DP.length; j++) {
            if (j + d < DP.length)
                sum += DP[j + d];
            if (chrs[0][j] == '.') {
                DPSum[j] = sum % mod;
            } else {
                DPSum[j] = 0;
            }
            if (j >= d)
                sum -= DP[j - d];
        }
        long res = 0;
        for (int i = 0; i < DP.length; i++) {
            res += DPSum[i];
        }
        return (int) (res % mod);
    }
}
