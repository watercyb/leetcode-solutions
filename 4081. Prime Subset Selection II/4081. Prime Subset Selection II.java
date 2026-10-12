/*
 * Problem: 4081. Prime Subset Selection II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/prime-subset-selection-ii/
 * Language: java
 * Date: 2026-10-12
 */

class Solution {
    static int[] primes;

    public List<Integer> maxPrimeSubset(int n, int s) {
        if (primes == null) {
            List<Integer> ps = new ArrayList<>();
            boolean[] nonPrimes = new boolean[1000];
            for (int i = 2; i < 1000; i++) {
                if (!nonPrimes[i]) {
                    ps.add(i);
                    for (int j = i * i; j < 1000; j += i) {
                        nonPrimes[j] = true;
                    }
                }
            }
            primes = new int[ps.size()];
            for (int i = 0; i < primes.length; i++) {
                primes[i] = ps.get(i);
            }
        }
        List<Integer>[] dp = new ArrayList[s + 1];
        dp[0] = new ArrayList<>();
        for (int prime : primes) {
            if (prime > n || prime > s)
                break;
            for (int i = s - prime; i >= 0; i--) {
                if (dp[i] == null)
                    continue;
                
                if (dp[i + prime] == null) {
                    dp[i + prime] = new ArrayList(dp[i]);
                    dp[i + prime].add(prime);
                } else if (dp[i].size() + 1 < dp[i + prime].size()) {
                    dp[i + prime] = new ArrayList(dp[i]);
                    dp[i + prime].add(prime);
                } else if (dp[i].size() + 1 == dp[i + prime].size()) {
                    int j = 0;
                    while (j < dp[i].size() && j < dp[i + prime].size()) {
                        if (dp[i].get(j) < dp[i + prime].get(j)) {
                            dp[i + prime] = new ArrayList(dp[i]);
                            dp[i + prime].add(prime);
                        } else if (dp[i].get(j) > dp[i + prime].get(j)) {
                            break;
                        }
                        j++;
                    }
                }
            }
        }
        for (int i = s; i > 0; i--) {
            if (dp[i] != null)
                return dp[i];
        }
        return new ArrayList<>();
    }
}
