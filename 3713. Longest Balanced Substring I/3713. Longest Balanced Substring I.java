/*
 * Problem: 3713. Longest Balanced Substring I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-balanced-substring-i/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int longestBalanced(String s) {
        char[] chrs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chrs.length && i <= chrs.length - res; i++) {
            int[] counts = new int[26];
            int types = 0;
            boolean[] seens = new boolean[26];
            int[] freqs = new int[chrs.length + 1];
            for (int j = i; j < chrs.length; j++) {
                int idx = chrs[j] - 'a';
                if (!seens[idx]) {
                    seens[idx] = true;
                    types++;
                }
                int count = counts[idx]++;
                freqs[count]--;
                freqs[count + 1]++;
                if (freqs[count + 1] == types && j - i + 1 > res)
                    res = j - i + 1;
            }
        }
        return res;
    }
}
