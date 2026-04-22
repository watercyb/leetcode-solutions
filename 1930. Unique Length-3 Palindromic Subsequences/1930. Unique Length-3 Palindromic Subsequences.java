/*
 * Problem: 1930. Unique Length-3 Palindromic Subsequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] chrs = s.toCharArray();
        int[] first = new int[26];
        Arrays.fill(first, chrs.length);
        int[] last = new int[26];
        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            if (first[idx] == chrs.length)
                first[idx] = i;
            last[idx] = i;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            boolean[] seens = new boolean[26];
            for (int j = first[i] + 1; j < last[i]; j++) {
                if (!seens[chrs[j] - 'a']) {
                    seens[chrs[j] - 'a'] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
