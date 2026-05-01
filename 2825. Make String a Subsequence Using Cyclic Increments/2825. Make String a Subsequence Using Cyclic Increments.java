/*
 * Problem: 2825. Make String a Subsequence Using Cyclic Increments
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] chrs1 = str1.toCharArray();
        char[] chrs2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chrs1.length && j < chrs2.length) {
            if (chrs1[i] == chrs2[j] || chrs1[i] + 1 == chrs2[j] || (chrs1[i] == 'z' && chrs2[j] == 'a'))
                j++;
            i++;
        }
        return j == chrs2.length;
    }
}
