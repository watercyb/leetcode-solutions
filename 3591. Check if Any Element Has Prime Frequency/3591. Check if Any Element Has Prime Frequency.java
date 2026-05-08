/*
 * Problem: 3591. Check if Any Element Has Prime Frequency
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-any-element-has-prime-frequency/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        boolean[] nonPrime = getPrime(100);
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }
        for (int count : counts) {
            if (!nonPrime[count])
                return true;
        }
        return false;
    }

    public boolean[] getPrime(int n) {
        boolean[] nonPrime = new boolean[n + 1];
        nonPrime[0] = true;
        nonPrime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (nonPrime[i])
                continue;
            for (int j = i * i; j <= n; j += i) {
                nonPrime[j] = true;
            }
        }
        return nonPrime;
    }
}
