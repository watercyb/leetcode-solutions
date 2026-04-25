/*
 * Problem: 2223. Sum of Scores of Built Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-scores-of-built-strings/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long sumScores(String s) {
        char[] chrs = s.toCharArray();
        int[] lens = new int[chrs.length];
        long res = chrs.length;
        int l = 0;
        int r = 0;
        for (int i = 1; i < chrs.length; i++) {
            if (i <= r)
                lens[i] = Math.min(lens[i - l], r - i + 1);
            while (lens[i] + i < chrs.length && chrs[lens[i] + i] == chrs[lens[i]]) {
                l = i;
                r = lens[i] + i;
                lens[i]++;
            }
            res += lens[i];
        }
        return res;
    }
}
