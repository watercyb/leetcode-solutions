/*
 * Problem: 3610. Minimum Number of Primes to Sum to Target
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-primes-to-sum-to-target/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minNumberOfPrimes(int n, int m) {
        if (nonPrime == null)
            getPrime();
        int[] DP = new int[n + 1];
        Arrays.fill(DP, Integer.MAX_VALUE / 2);
        DP[0] = 0;
        int count = 0;
        int idx = 2;
        while (count < m && idx < nonPrime.length) {
            if (!nonPrime[idx]) {
                for (int i = 0; i < DP.length - idx; i++) {
                    DP[i + idx] = Math.min(DP[i] + 1, DP[i + idx]);
                }
                count++;
            }
            idx++;
        }
        if (DP[DP.length - 1] >= Integer.MAX_VALUE / 2)
            return -1;
        return DP[DP.length - 1];
    }

    boolean[] nonPrime;

    public boolean[] getPrime() {
        nonPrime = new boolean[1001];
        nonPrime[0] = true;
        nonPrime[1] = true;
        for (int i = 2; i <= 1000; i++) {
            if (nonPrime[i])
                continue;
            for (int j = i * i; j <= 1000; j += i) {
                nonPrime[j] = true;
            }
        }
        return nonPrime;
    }
}
