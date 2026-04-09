/*
 * Problem: 859. Buddy Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/buddy-strings/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        char[] chrs1 = s.toCharArray();
        char[] chrs2 = goal.toCharArray();
        boolean isRepeat = false;
        boolean[] seens = new boolean['z' + 1];
        int[] diff = { 0, -1, -1 };
        for (int i = 0; i < chrs1.length; i++) {
            if (seens[chrs1[i]])
                isRepeat = true;
            seens[chrs1[i]] = true;
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
        return ((diff[0] == 0 && isRepeat)
                || (diff[0] == 2 && chrs1[diff[1]] == chrs2[diff[2]] && chrs1[diff[2]] == chrs2[diff[1]]));
    }
}
