/*
 * Problem: 1047. Remove All Adjacent Duplicates In String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public String removeDuplicates(String s) {
        char[] chrs = s.toCharArray();
        int l = -1;
        int r = 0;
        while (r < chrs.length) {
            if (l >= 0 && chrs[l] == chrs[r]) {
                l--;
            } else {
                chrs[++l] = chrs[r];
            }
            r++;
        }
        return new String(chrs, 0, l + 1);
    }
}
