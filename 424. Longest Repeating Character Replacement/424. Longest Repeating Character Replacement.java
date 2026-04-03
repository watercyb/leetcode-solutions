/*
 * Problem: 424. Longest Repeating Character Replacement
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int characterReplacement(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[26];
        int res = 0;
        int j = 0;
        int maxChr = '#';
        int maxChrNum = 0;
        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'A';
            counts[idx]++;
            if (chrs[i] == maxChr) {
                maxChrNum++;
            } else {
                if (counts[idx] > maxChrNum) {
                    maxChrNum = counts[idx];
                    maxChr = chrs[i];
                }
            }
            if (i - j - maxChrNum >= k) {
                res = i - j;
                if (chrs[j] == maxChr)
                    maxChrNum--;
                counts[chrs[j] - 'A']--;
                j++;
            }
        }
        return Math.max(chrs.length - j, res);
    }
}
