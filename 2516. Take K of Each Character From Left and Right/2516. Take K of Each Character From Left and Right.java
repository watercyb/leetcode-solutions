/*
 * Problem: 2516. Take K of Each Character From Left and Right
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0;
        char[] chrs = s.toCharArray();
        int[] counts = new int['d'];
        counts['a'] = k;
        counts['b'] = k;
        counts['c'] = k;
        int count = 0;
        int l = -1;
        while (l < chrs.length - 1 && count != 3) {
            if (counts[chrs[++l]]-- == 1)
                count++;
        }
        if (count != 3)
            return -1;
        int res = l + 1;
        int r = chrs.length - 1;
        while (l >= 0) {
            if (counts[chrs[r]]-- == 1)
                count++;
            while (l >= 0 && count == 3) {
                if (counts[chrs[l--]]++ == 0)
                    count--;
            }
            if (count == 3)
                return Math.min(l + 1 + chrs.length - r, res);
            res = Math.min(l + 2 + chrs.length - (r--), res);
        }
        return res;
    }
}
