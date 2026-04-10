/*
 * Problem: 903. Valid Permutations for DI Sequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/valid-permutations-for-di-sequence/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int numPermsDISequence(String s) {
        int mod = 1_000_000_007;
        long[] DP = new long[s.length() + 1];
        DP[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                DP[i + 1] = 0;
                for (int j = i - 1; j >= 0; j--) {
                    DP[j] = (DP[j] + DP[j + 1]) % mod;
                }
            } else {
                long sum = DP[0];
                DP[0] = 0;
                for (int j = 1; j <= i + 1; j++) {
                    long temp = DP[j];
                    DP[j] = sum;
                    sum = (sum + temp) % mod;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < DP.length; i++) {
            res += DP[i];
        }
        return (int) (res % mod);
    }
}
