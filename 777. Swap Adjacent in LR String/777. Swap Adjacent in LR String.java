/*
 * Problem: 777. Swap Adjacent in LR String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/swap-adjacent-in-lr-string/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean canTransform(String start, String end) {
        char[] chrs1 = start.toCharArray();
        char[] chrs2 = end.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chrs1.length || j < chrs2.length) {
            while (i < chrs1.length && chrs1[i] == 'X') {
                i++;
            }
            while (j < chrs2.length && chrs2[j] == 'X') {
                j++;
            }
            if (i == chrs1.length && j == chrs2.length)
                break;
            if (i == chrs1.length || j == chrs2.length
                    || chrs1[i] != chrs2[j] || (chrs1[i] == 'L' && i < j) || (chrs1[i] == 'R' && i > j))
                return false;
            i++;
            j++;
        }
        return true;
    }
}
