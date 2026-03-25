/*
 * Problem: 32. Longest Valid Parentheses
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-valid-parentheses/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int longestValidParentheses(String s) {
        char[] chrs = s.toCharArray();
        int count = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                j = i + 1;
                count = 0;
            } else if (count == 0) {
                res = Math.max(i - j + 1, res);
            }
        }
        count = 0;
        j = chrs.length - 1;
        for (int i = chrs.length - 1; i >= 0; i--) {
            if (chrs[i] == ')') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                j = i - 1;
                count = 0;
            } else if (count == 0) {
                res = Math.max(j - i + 1, res);
            }
        }
        return res;
    }
}
