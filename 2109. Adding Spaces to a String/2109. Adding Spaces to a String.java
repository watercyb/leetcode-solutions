/*
 * Problem: 2109. Adding Spaces to a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/adding-spaces-to-a-string/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] chrs = new char[s.length() + spaces.length];
        int idxChrs = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx < spaces.length && spaces[idx] == i) {
                chrs[idxChrs++] = ' ';
                idx++;
            }
            chrs[idxChrs++] = s.charAt(i);
        }
        return new String(chrs);
    }
}
