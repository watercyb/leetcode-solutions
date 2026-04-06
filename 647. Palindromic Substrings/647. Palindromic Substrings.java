/*
 * Problem: 647. Palindromic Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/palindromic-substrings/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int countSubstrings(String s) {
        char[] chrs = s.toCharArray();
        int res = chrs.length;
        for (int i = 0; i < chrs.length - 1; i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < chrs.length) {
                if (chrs[l--] != chrs[r++])
                    break;
                res++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < chrs.length) {
                if (chrs[l--] != chrs[r++])
                    break;
                res++;
            }
        }
        return res;
    }
}
