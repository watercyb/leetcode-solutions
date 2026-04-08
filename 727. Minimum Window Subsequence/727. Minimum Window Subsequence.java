/*
 * Problem: 727. Minimum Window Subsequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-window-subsequence/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String minWindow(String s1, String s2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        int j = 0;
        int len = 0;
        int min = Integer.MAX_VALUE;
        int idx = -2;
        while (j < chrs1.length) {
            if (chrs1[j] == chrs2[len]) {
                len++;
                if (len == chrs2.length) {
                    len--;
                    int i = j;
                    while (len >= 0) {
                        if (chrs1[i] == chrs2[len])
                            len--;
                        i--;
                    }
                    if (j - i < min) {
                        min = j - i;
                        idx = i;
                    }
                    j = i + 1;
                    len = 0;
                }
            }
            j++;
        }
        if (idx == -2)
            return "";
        return s1.substring(idx + 1, idx + min + 1);
    }
}
