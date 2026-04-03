/*
 * Problem: 395. Longest Substring with At Least K Repeating Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int longestSubstring(String s, int k) {
        if (k <= 1)
            return s.length();
        char[] chrs = s.toCharArray();
        boolean[] seen = new boolean['z' + 1];
        int n = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (!seen[chrs[i]]) {
                n++;
                seen[chrs[i]] = true;
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(chk(chrs, k, i), res);
        }
        return res;
    }

    public int chk(char[] chrs, int k, int n) {
        int[] counts = new int['z' + 1];
        int res = 0;
        int need = 0;
        int diff = 0;
        int j = 0;
        for (int i = 0; i < chrs.length; i++) {
            counts[chrs[i]]++;
            if (counts[chrs[i]] == 1) {
                need++;
                diff++;
            } else if (counts[chrs[i]] == k) {
                need--;
            }
            while (diff > n) {
                if (counts[chrs[j]] == 1) {
                    need--;
                    diff--;
                } else if (counts[chrs[j]] == k) {
                    need++;
                }
                counts[chrs[j]]--;
                j++;
            }
            if (need == 0)
                res = Math.max(i - j + 1, res);
        }
        return res;
    }
}
