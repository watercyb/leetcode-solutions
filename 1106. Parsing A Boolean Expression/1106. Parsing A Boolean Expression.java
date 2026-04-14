/*
 * Problem: 1106. Parsing A Boolean Expression
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/parsing-a-boolean-expression/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {

    int idx = 0;

    public boolean parseBoolExpr(String expression) {
        char chr = expression.charAt(idx);
        if (chr == '!') {
            idx += 2;
            boolean res = !parseBoolExpr(expression);
            idx++;
            return res;
        } else if (chr == '&') {
            idx += 2;
            boolean res = parseBoolExpr(expression);
            while (expression.charAt(idx) != ')') {
                idx++;
                res &= parseBoolExpr(expression);
            }
            idx++;
            return res;
        } else if (chr == '|') {
            idx += 2;
            boolean res = parseBoolExpr(expression);
            while (expression.charAt(idx) != ')') {
                idx++;
                res |= parseBoolExpr(expression);
            }
            idx++;
            return res;
        } else if (chr == 't') {
            idx++;
            return true;
        } else {
            idx++;
            return false;
        }
    }
}
