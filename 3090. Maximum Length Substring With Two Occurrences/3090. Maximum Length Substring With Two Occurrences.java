/*
 * Problem: 3090. Maximum Length Substring With Two Occurrences
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maximumLengthSubstring(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        int j = 0;
        int res = 0;
        for (int i = 0; j < chrs.length; i++) {
            while (j < chrs.length && counts[chrs[j]] < 2) {
                counts[chrs[j]]++;
                j++;
            }
            res = Math.max(res, j - i);
            counts[chrs[i]]--;
        }
        return res;
    }
}
