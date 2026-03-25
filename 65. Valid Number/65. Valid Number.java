/*
 * Problem: 65. Valid Number
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/valid-number/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean isNumber(String s) {
        char[] chrs = s.toCharArray();
        boolean digit = false;
        boolean dot = false;
        boolean exp = false;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] >= '0' && chrs[i] <= '9') {
                digit = true;
            } else if (chrs[i] == '.') {
                if (dot || exp)
                    return false;
                dot = true;
            } else if (chrs[i] == 'e' || chrs[i] == 'E') {
                if (!digit || exp)
                    return false;
                exp = true;
                digit = false;
            } else if (chrs[i] == '+' || chrs[i] == '-') {
                if (i != 0 && chrs[i - 1] != 'e' && chrs[i - 1] != 'E')
                    return false;
            } else {
                return false;
            }
        }
        return digit;
    }
}
