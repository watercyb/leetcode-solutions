/*
 * Problem: 439. Ternary Expression Parser
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/ternary-expression-parser/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String parseTernary(String expression) {
        return String.valueOf(dfs(expression.toCharArray()));
    }

    int idx = 0;

    public char dfs(char[] chrs) {
        char a = chrs[idx++];
        if (idx == chrs.length || chrs[idx] != '?')
            return a;
        idx++;
        char b = dfs(chrs);
        idx++;
        char c = dfs(chrs);
        if (a == 'T') {
            return b;
        } else {
            return c;
        }
    }
}
