/*
 * Problem: 1790. Check if One String Swap Can Make Strings Equal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        int[] diff = { 0, -1, -1 };
        for (int i = 0; i < chrs1.length; i++) {
            if (chrs1[i] != chrs2[i]) {
                if (diff[0] == 0) {
                    diff[1] = i;
                } else if (diff[0] == 1) {
                    diff[2] = i;
                } else {
                    return false;
                }
                diff[0]++;
            }
        }
        return (diff[0] == 0 || (diff[0] == 2 && chrs1[diff[1]] == chrs2[diff[2]] && chrs1[diff[2]] == chrs2[diff[1]]));
    }
}
