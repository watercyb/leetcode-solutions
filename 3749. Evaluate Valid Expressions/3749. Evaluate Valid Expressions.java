/*
 * Problem: 3749. Evaluate Valid Expressions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/evaluate-valid-expressions/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long evaluateExpression(String expression) {
        chrs = expression.toCharArray();
        return dfs();
    }

    char[] chrs;
    int idx = 0;

    public long dfs() {
        long res = 0;
        int p = 1;
        switch (chrs[idx]) {
            case 'a':
                idx += 4;
                res = dfs();
                idx++;
                res += dfs();
                idx++;
                return res;

            case 's':
                idx += 4;
                res = dfs();
                idx++;
                res -= dfs();
                idx++;
                return res;

            case 'm':
                idx += 4;
                res = dfs();
                idx++;
                res *= dfs();
                idx++;
                return res;

            case 'd':
                idx += 4;
                res = dfs();
                idx++;
                res /= dfs();
                idx++;
                return res;

            case '-':
                p = -1;
                idx++;
                break;
        }
        while (idx < chrs.length && Character.isDigit(chrs[idx])) {
            res = res * 10 + chrs[idx] - '0';
            idx++;
        }
        return res * p;
    }
}
