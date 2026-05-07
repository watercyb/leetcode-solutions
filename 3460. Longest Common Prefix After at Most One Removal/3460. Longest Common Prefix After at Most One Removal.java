/*
 * Problem: 3460. Longest Common Prefix After at Most One Removal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-common-prefix-after-at-most-one-removal/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int longestCommonPrefix(String s, String t) {
        int res = 0;
        int lim = Math.min(s.length(), t.length());
        for (int i = 0; i < lim && s.charAt(i) == t.charAt(i); i++) {
            res++;
        }
        lim = Math.min(s.length(), t.length() + 1);
        for (int i = res + 1; i < lim && s.charAt(i) == t.charAt(i - 1); i++) {
            res++;
        }
        return res;
    }
}
