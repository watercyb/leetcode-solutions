/*
 * Problem: 3821. Find Nth Smallest Integer With K One Bits
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-nth-smallest-integer-with-k-one-bits/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long nthSmallest(long n, int k) {
        long[][] DP = getDP(n, k);
        long res = 0;
        int count = 0;
        for (int i = 0; i < DP.length; i++) {
            res = res << 1;
            if (DP[i][count] < n) {
                 n -= DP[i][count];
                count++;
                res++;
            }
        }
        return res;
    }

    public long[][] getDP(long n, int k) {
        long[][] DP = new long[50][k + 1];
        for (int i = k; i < DP.length; i++) {
            DP[i][k] = 1;
        }
        for (int i = k - 1; i >= 0; i--) {
            for (int j = DP.length - 2; j >= i; j--) {
                DP[j][i] = DP[j + 1][i] + DP[j + 1][i + 1];
            }
        }
        return DP;
    }
}
