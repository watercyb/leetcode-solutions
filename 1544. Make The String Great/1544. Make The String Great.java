/*
 * Problem: 1544. Make The String Great
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/make-the-string-great/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public String makeGood(String s) {
        char[] chrs = s.toCharArray();
        for (int i = 1; i < chrs.length; i++) {
            int k = i - 1;
            while (k >= 0 && chrs[k] == '@') {
                k--;
            }
            if (k >= 0 && Math.abs(chrs[i] - chrs[k]) == 32) {
                chrs[i] = '@';
                chrs[k] = '@';
            }
        }
        StringBuilder SB = new StringBuilder();
        for (char chr : chrs) {
            if (chr != '@')
                SB.append(chr);
        }
        return SB.toString();
    }
}
