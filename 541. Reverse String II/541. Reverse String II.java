/*
 * Problem: 541. Reverse String II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-string-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String reverseStr(String s, int k) {
        char[] chrs = s.toCharArray();
        int k2 = 2 * k;
        for (int i = 0; i < chrs.length; i += k2) {
            reverse(chrs, i, Math.min(i + k - 1, chrs.length - 1));
        }
        return new String(chrs);
    }

    public void reverse(char[] chrs, int i, int j) {
        while (i < j) {
            char chrTemp = chrs[i];
            chrs[i] = chrs[j];
            chrs[j] = chrTemp;
            i++;
            j--;
        }
    }
}
