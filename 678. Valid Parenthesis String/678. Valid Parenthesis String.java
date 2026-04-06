/*
 * Problem: 678. Valid Parenthesis String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-parenthesis-string/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public boolean checkValidString(String s) {
        char[] chrs=s.toCharArray();
        int l = 0;
        int r = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '(' || chrs[i]== '*') {
                l++;
            } else {
                l--;
            }
            if (chrs[chrs.length-1-i] == ')' || chrs[chrs.length-1-i] == '*') {
                r++;
            } else {
                r--;
            }
            if (l < 0 || r < 0) {
                return false;
            }
        }
        return true;
    }
}
