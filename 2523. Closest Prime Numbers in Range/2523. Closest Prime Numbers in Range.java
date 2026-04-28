/*
 * Problem: 2523. Closest Prime Numbers in Range
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/closest-prime-numbers-in-range/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    static int[] primes;

    public int[] closestPrimes(int left, int right) {
        if (primes == null) {
            boolean[] nonPrimes = new boolean[1000001];
            int count = 0;
            for (int i = 2; i < nonPrimes.length; i++) {
                if (nonPrimes[i])
                    continue;
                count++;
                for (int j = i + i; j < nonPrimes.length; j += i) {
                    nonPrimes[j] = true;
                }
            }
            primes = new int[count];
            int idx = 0;
            for (int i = 2; i < nonPrimes.length; i++) {
                if (!nonPrimes[i])
                    primes[idx++] = i;
            }
        }
        int[] res = new int[] { -1, -1 };
        int min = Integer.MAX_VALUE;
        int idx = binarySearch(left);
        if (idx >= primes.length - 1)
            return res;
        for (int i = idx + 1; i < primes.length && primes[i] <= right; i++) {
            if (primes[i] - primes[i - 1] < min) {
                min = primes[i] - primes[i - 1];
                res[0] = primes[i - 1];
                res[1] = primes[i];
            }
        }
        return res;
    }

    public int binarySearch(int left) {
        int l = 0;
        int r = primes.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (primes[mid] >= left) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
