/*
 * Problem: 227. Basic Calculator II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/basic-calculator-ii/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    int idx = 0;

    public int calculate(String s) {
        char[] chrs = s.toCharArray();
        int res = 0;
        int a = getNum(chrs);
        int p = 1;
        while (idx < chrs.length) {
            if (chrs[idx] == '+') {
                res += p * a;
                p = 1;
                idx++;
                a = getNum(chrs);
            } else if (chrs[idx] == '-') {
                res += p * a;
                p = -1;
                idx++;
                a = getNum(chrs);
            } else if (chrs[idx] == '*') {
                idx++;
                a = a * getNum(chrs);
            } else if (chrs[idx] == '/') {
                idx++;
                a = a / getNum(chrs);
            }
        }
        return res + p * a;
    }

    public int getNum(char[] chrs) {
        while (idx < chrs.length && chrs[idx] == ' ') {
            idx++;
        }
        int res = 0;
        while (idx < chrs.length && chrs[idx] >= '0' && chrs[idx] <= '9') {
            res *= 10;
            res += chrs[idx++] - '0';
        }
        while (idx < chrs.length && chrs[idx] == ' ') {
            idx++;
        }
        return res;
    }
}
