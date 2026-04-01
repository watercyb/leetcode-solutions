/*
 * Problem: 313. Super Ugly Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/super-ugly-number/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] DP = new long[n];
        DP[0] = 1;
        int l = primes.length;
        int[] indexes = new int[l];
        long[] next = new long[l];
        for (int i = 0; i < l; i++) {
            next[i] = primes[i];
        }
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < l; j++) {
                min = Math.min(next[j], min);
            }
            DP[i] = min;
            for (int j = 0; j < l; j++) {
                if (next[j] == min) {
                    indexes[j]++;
                    next[j] = DP[indexes[j]] * primes[j];
                }
            }
        }
        return (int) DP[n - 1];
    }
}
