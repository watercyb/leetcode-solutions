/*
 * Problem: 2840. Check if Strings Can be Made Equal With Operations II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public boolean checkStrings(String s1, String s2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        int[][] counts = new int[2][26];
        for (int i = 0; i < chrs1.length; i++) {
            counts[i & 1][chrs1[i] - 'a']++;
        }
        for (int i = 0; i < chrs2.length; i++) {
            if (--counts[i & 1][chrs2[i] - 'a'] < 0)
                return false;
        }
        return true;
    }
}
