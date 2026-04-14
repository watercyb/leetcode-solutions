/*
 * Problem: 1175. Prime Arrangements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/prime-arrangements/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int numPrimeArrangements(int n) {
        int mod = 1_000_000_007;
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (notPrimes[i])
                continue;
            count++;
            for (int j = i + i; j <= n; j += i) {
                notPrimes[j] = true;
            }
        }
        long a = 1;
        long b = 1;
        for (int i = 2; i <= n - count; i++) {
            a = (a * i) % mod;
        }
        for (int i = 2; i <= count; i++) {
            b = (b * i) % mod;
        }
        return (int) (a * b % mod);
    }
}
