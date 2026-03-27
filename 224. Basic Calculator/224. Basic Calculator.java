/*
 * Problem: 224. Basic Calculator
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/basic-calculator/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    public int calculate(String s) {
        return dfs(s.toCharArray());
    }

    int idx = 0;

    public int dfs(char[] chrs) {
        int res = 0;
        int tmp = 0;
        int p = 1;
        while (idx < chrs.length) {
            if (Character.isDigit(chrs[idx])) {
                tmp *= 10;
                tmp += chrs[idx] - '0';
            } else if (chrs[idx] == '+') {
                res += p * tmp;
                tmp = 0;
                p = 1;
            } else if (chrs[idx] == '-') {
                res += p * tmp;
                tmp = 0;
                p = -1;
            } else if (chrs[idx] == '(') {
                idx++;
                res += p * dfs(chrs);
            } else if (chrs[idx] == ')') {
                return res + p * tmp;
            }
            idx++;
        }
        return res + p * tmp;
    }
}
