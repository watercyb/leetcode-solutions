/*
 * Problem: 762. Prime Number of Set Bits in Binary Representation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] isPrimes = new boolean[21];
        isPrimes[2] = true;
        isPrimes[3] = true;
        isPrimes[5] = true;
        isPrimes[7] = true;
        isPrimes[11] = true;
        isPrimes[13] = true;
        isPrimes[17] = true;
        isPrimes[19] = true;
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (isPrimes[Integer.bitCount(i)])
                res++;
        }
        return res;
    }
}
