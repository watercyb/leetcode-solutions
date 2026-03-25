/*
 * Problem: 8. String to Integer (atoi)
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/string-to-integer-atoi/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int p = 1;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == ' ')
                continue;
            if (chr == '+') {
                j = i + 1;
                break;
            }
            if (chr == '-') {
                j = i + 1;
                p *= -1;
                break;
            }
            if (chr >= '0' && chr <= '9') {
                j = i;
                break;
            }
            return (int) res;
        }
        while (j < s.length()) {
            char chr = s.charAt(j);
            if (Character.isDigit(chr)) {
                res *= 10;
                res += chr - '0';
            } else {
                break;
            }
            if (res * p > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (res * p < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            j++;
        }
        return (int) (res * p);
    }
}
