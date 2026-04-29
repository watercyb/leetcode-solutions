/*
 * Problem: 2696. Minimum String Length After Removing Substrings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minLength(String s) {
        char[] chrs = s.toCharArray();
        int j = 0;
        for (int i = 1; i < chrs.length; i++) {
            if (j >= 0 && ((chrs[i] == 'B' && chrs[j] == 'A') || (chrs[i] == 'D' && chrs[j] == 'C'))) {
                j--;
            } else {
                chrs[++j] = chrs[i];
            }
        }
        return j + 1;
    }
}
