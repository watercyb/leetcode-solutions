/*
 * Problem: 3561. Resulting String After Adjacent Removals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/resulting-string-after-adjacent-removals/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public String resultingString(String s) {
        char[] chrs = s.toCharArray();
        int l = 0;
        int r = 0;
        while (r < chrs.length) {
            if (l > 0 && Math.abs(chrs[l - 1] - chrs[r]) % 24 == 1) {
                l--;
                r++;
            } else {
                chrs[l++] = chrs[r++];
            }
        }
        return new String(chrs, 0, l);
    }
}
