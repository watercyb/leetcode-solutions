/*
 * Problem: 3770. Largest Prime from Consecutive Prime Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-prime-from-consecutive-prime-sum/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int largestPrime(int n) {
        if (nonPrime == null)
            getPrime(500000);
        int sum = 0;
        int res = 0;
        for (int prime : primes) {
            sum += prime;
            if (sum <= n) {
                if (!nonPrime[sum])
                    res = sum;
            } else {
                break;
            }
        }
        return res;
    }

    static boolean[] nonPrime;
    static int[] primes;

    public void getPrime(int n) {
        nonPrime = new boolean[n + 1];
        nonPrime[0] = true;
        nonPrime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (nonPrime[i])
                continue;
            for (long j = (long) i * i; j <= n; j += i) {
                nonPrime[(int) j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < nonPrime.length; i++) {
            if (!nonPrime[i])
                count++;
        }
        primes = new int[count];
        int idx = 0;
        for (int i = 2; i < nonPrime.length; i++) {
            if (!nonPrime[i])
                primes[idx++] = i;
        }
    }
}
