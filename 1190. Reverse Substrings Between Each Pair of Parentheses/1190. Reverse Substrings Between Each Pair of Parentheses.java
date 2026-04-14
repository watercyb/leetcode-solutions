/*
 * Problem: 1190. Reverse Substrings Between Each Pair of Parentheses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public String reverseParentheses(String s) {
        char[] chrs = s.toCharArray();
        return dfs(chrs).toString();
    }

    int i = 0;

    public String dfs(char[] chrs) {
        StringBuilder SB = new StringBuilder();
        while (i < chrs.length) {
            if (chrs[i] == '(') {
                i++;
                SB.append(dfs(chrs));
            } else if (chrs[i] == ')') {
                i++;
                return SB.reverse().toString();
            } else {
                SB.append(chrs[i]);
                i++;
            }
        }
        return SB.toString();
    }
}
