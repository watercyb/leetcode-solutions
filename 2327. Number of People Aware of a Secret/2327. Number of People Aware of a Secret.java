/*
 * Problem: 2327. Number of People Aware of a Secret
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-people-aware-of-a-secret/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1_000_000_007;
        long[] DP = new long[delay + forget + n];
        DP[delay] = 1;
        DP[forget] = -1;
        long sum = 0;
        long res = n < forget ? 1 : 0;
        for (int i = delay; i < n; i++) {
            sum = (sum + DP[i]) % mod;
            if (i + delay >= n) {
                res += sum;
            } else {
                DP[i + delay] = (DP[i + delay] + sum) % mod;
                DP[i + forget] = (DP[i + forget] - sum + mod) % mod;
            }
        }
        sum += res;
        return (int) (sum % mod);
    }
}
