/*
 * Problem: 3114. Latest Time You Can Obtain After Replacing Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/latest-time-you-can-obtain-after-replacing-characters/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public String findLatestTime(String s) {
        char[] chrs = s.toCharArray();
        if (chrs[0] == '?' && chrs[1] == '?') {
            chrs[0] = chrs[1] = '1';
        } else if (chrs[0] == '?') {
            if (chrs[1] <= '1') {
                chrs[0] = '1';
            } else {
                chrs[0] = '0';
            }
        } else if (chrs[1] == '?') {
            if (chrs[0] == '1') {
                chrs[1] = '1';
            } else {
                chrs[1] = '9';
            }
        }
        if (chrs[3] == '?') {
            chrs[3] = '5';
        }
        if (chrs[4] == '?') {
            chrs[4] = '9';
        }
        return new String(chrs);
    }
}
