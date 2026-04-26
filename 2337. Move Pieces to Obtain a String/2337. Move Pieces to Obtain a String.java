/*
 * Problem: 2337. Move Pieces to Obtain a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public boolean canChange(String start, String target) {
        char[] chrs1 = start.toCharArray();
        char[] chrs2 = target.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chrs1.length && chrs1[i] == '_') {
            i++;
        }
        while (j < chrs1.length && chrs2[j] == '_') {
            j++;
        }
        while (i < chrs1.length && j < chrs2.length) {
            if (chrs1[i] != chrs2[j] || (chrs1[i] == 'L' && i < j) || (chrs1[i] == 'R' && i > j))
                return false;
            i++;
            j++;
            while (i < chrs1.length && chrs1[i] == '_') {
                i++;
            }
            while (j < chrs1.length && chrs2[j] == '_') {
                j++;
            }
        }
        return i == chrs1.length && j == chrs2.length;
    }
}
