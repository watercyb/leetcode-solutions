/*
 * Problem: 3110. Score of a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/score-of-a-string/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int scoreOfString(String s) {
        char[] chrs = s.toCharArray();
        int res = 0;
        for (int i = 1; i < chrs.length; i++) {
            res += Math.abs(chrs[i] - chrs[i - 1]);
        }
        return res;
    }
}
