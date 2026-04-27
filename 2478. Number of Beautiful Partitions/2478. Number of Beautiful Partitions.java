/*
 * Problem: 2478. Number of Beautiful Partitions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-beautiful-partitions/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        int mod = 1_000_000_007;
        boolean[] primes = new boolean['9' + 1];
        primes['2'] = true;
        primes['3'] = true;
        primes['5'] = true;
        primes['7'] = true;
        char[] chrs = s.toCharArray();
        if (!primes[chrs[0]])
            return 0;
        if (primes[chrs[chrs.length - 1]])
            return 0;
        int l = 0;
        int r = 0;
        long[][] DP = new long[chrs.length + 1][k + 1];
        DP[0][0] = 1;
        while (l < chrs.length) {
            while (r < chrs.length && r - l + 1 < minLength) {
                r++;
            }
            while (r < chrs.length - 1 && (primes[chrs[r]] || !primes[chrs[r + 1]])) {
                r++;
            }
            if (r < chrs.length && primes[chrs[l]] && (l == 0 || !primes[chrs[l - 1]])) {
                int idx = r + 1;
                for (int j = k - 1; j > 0; j--) {
                    DP[idx][j + 1] += DP[l][j];
                }
                DP[idx][1] += DP[l][0];
            }
            for (int j = 1; j <= k; j++) {
                DP[l + 1][j] = (DP[l + 1][j] + DP[l][j]) % mod;
            }
            l++;
        }
        return (int) DP[DP.length - 1][k];
    }
}
