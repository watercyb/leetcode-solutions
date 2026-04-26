/*
 * Problem: 2311. Longest Binary Subsequence Less Than or Equal to K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int longestSubsequence(String s, int k) {
        char[] chrs = s.toCharArray();
        long sum = 0;
        int res = 0;
        for (int i = chrs.length - 1; i >= 0; i--) {
            if (chrs[i] == '0') {
                res++;
            } else {
                int len = chrs.length - i - 1;
                if (len < 32 && sum + (1l << len) <= k) {
                    sum += 1 << len;
                    res++;
                }
            }
        }
        return res;
    }
}
