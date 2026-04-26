/*
 * Problem: 2370. Longest Ideal Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-ideal-subsequence/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int longestIdealString(String s, int k) {
        int[] DP = new int[26];
        DP[s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            int l = Math.max(idx - k, 0);
            int r = Math.min(idx + k, 25);
            int max = 0;
            for (int j = l; j <= r; j++) {
                max = Math.max(DP[j], max);
            }
            DP[idx] = max + 1;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = Math.max(DP[i], res);
        }
        return res;
    }
}
