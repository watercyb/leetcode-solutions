/*
 * Problem: 186. Reverse Words in a String II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, j, i - 1);
                j = i + 1;
            }
        }
        reverse(s, j, s.length - 1);
    }

    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char chr = s[l];
            s[l] = s[r];
            s[r] = chr;
            l++;
            r--;
        }
    }
}
