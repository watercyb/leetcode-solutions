/*
 * Problem: 4079. Prime Subset Selection I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/prime-subset-selection-i/
 * Language: java
 * Date: 2026-10-12
 */

class Solution {
    static int[] primes;

    public List<Integer> maxPrimes(int n, int s) {
        if (primes == null) {
            List<Integer> ps = new ArrayList<>();
            boolean[] nonPrimes = new boolean[1000000];
            for (int i = 2; i < 1000000; i++) {
                if (!nonPrimes[i]) {
                    ps.add(i);
                    if ((long) i * i >= 1000000)
                        continue;
                    for (int j = i * i; j < 1000000; j += i) {
                        nonPrimes[j] = true;
                    }
                }
            }
            primes = new int[ps.size()];
            for (int i = 0; i < primes.length; i++) {
                primes[i] = ps.get(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int prime : primes) {
            if (sum + prime > s || prime > n)
                break;
            sum += prime;
            res.add(prime);
        }
        return res;
    }
}
