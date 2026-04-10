/*
 * Problem: 917. Reverse Only Letters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-only-letters/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chrs = s.toCharArray();
        int l = 0;
        int r = chrs.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(chrs[l])) {
                l++;
            }
            while (l < r && !Character.isLetter(chrs[r])) {
                r--;
            }
            char chrTemp = chrs[l];
            chrs[l] = chrs[r];
            chrs[r] = chrTemp;
            l++;
            r--;
        }
        return new String(chrs);
    }
}
