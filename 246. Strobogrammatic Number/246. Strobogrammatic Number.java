/*
 * Problem: 246. Strobogrammatic Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/strobogrammatic-number/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] chrs = num.toCharArray();
        int l = 0;
        int r = chrs.length - 1;
        while (l < r) {
            if ((chrs[l] == chrs[r] && (chrs[l] != '0' && chrs[l] != '1' && chrs[l] != '8'))
                    || (chrs[l] != chrs[r] && (chrs[l] != '6' || chrs[r] != '9') && (chrs[l] != '9' || chrs[r] != '6')))
                return false;
            l++;
            r--;
        }
        if (l == r)
            return chrs[l] == '0' || chrs[l] == '1' || chrs[l] == '8';
        return true;
    }
}
