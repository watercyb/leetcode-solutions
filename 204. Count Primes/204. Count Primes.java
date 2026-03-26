/*
 * Problem: 204. Count Primes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-primes/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (notPrimes[i])
                continue;
            for (int j = i; i * j < n; j++) {
                notPrimes[i * j] = true;
            }
        }
        int res = 0;
        for (int i = 2; i < notPrimes.length; i++) {
            if (!notPrimes[i])
                res++;
        }
        return res;
    }
}
