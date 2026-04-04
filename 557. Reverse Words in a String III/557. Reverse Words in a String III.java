/*
 * Problem: 557. Reverse Words in a String III
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public String reverseWords(String s) {
        char[] chrs = s.toCharArray();
        int l = 0;
        int r = 0;
        while (l < chrs.length) {
            while (r < chrs.length && chrs[r] != ' ') {
                r++;
            }
            int nextL = r;
            while (nextL < chrs.length && chrs[nextL] == ' ') {
                nextL++;
            }
            r--;
            while (l < r) {
                char tmp = chrs[l];
                chrs[l] = chrs[r];
                chrs[r] = tmp;
                l++;
                r--;
            }
            l = nextL;
            r = nextL;
        }
        return new String(chrs);
    }
}
