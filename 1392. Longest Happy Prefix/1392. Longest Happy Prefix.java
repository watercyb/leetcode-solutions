/*
 * Problem: 1392. Longest Happy Prefix
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-happy-prefix/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public String longestPrefix(String s) {
        char[] chrs = s.toCharArray();
        int[] lsp = new int[chrs.length];
        int len = 0;
        int i = 1;
        while (i < chrs.length) {
            if (chrs[len] == chrs[i]) {
                lsp[i++] = ++len;
            } else {
                if (len == 0) {
                    i++;
                } else {
                    len = lsp[len - 1];
                }
            }
        }
        return s.substring(0, lsp[chrs.length - 1]);
    }
}
