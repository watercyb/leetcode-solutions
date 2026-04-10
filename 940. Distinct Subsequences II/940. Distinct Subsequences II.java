/*
 * Problem: 940. Distinct Subsequences II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/distinct-subsequences-ii/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1_000_000_007;
        char[] chrs = s.toCharArray();
        long[] DP = new long[26];
        long sum = 0;
        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            long temp = (sum - DP[idx] + 1 + mod) % mod;
            sum = (sum + temp) % mod;
            DP[idx] = (DP[idx] + temp) % mod;
        }
        return (int) (sum % mod);
    }
}
