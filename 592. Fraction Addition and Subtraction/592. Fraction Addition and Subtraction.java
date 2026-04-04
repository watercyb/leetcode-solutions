/*
 * Problem: 592. Fraction Addition and Subtraction
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/fraction-addition-and-subtraction/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public String fractionAddition(String expression) {
        char[] chrs = expression.toCharArray();
        int idx = 0;
        int a = 0;
        int b = 1;
        int p = 1;
        int c = 0;
        int d = 0;
        while (idx < chrs.length) {
            if (chrs[idx] == '+') {
                p = 1;
            } else if (chrs[idx] == '-') {
                p = -1;
            } else if (Character.isDigit(chrs[idx])) {
                c = chrs[idx] - '0';
                if (Character.isDigit(chrs[idx + 1])) {
                    c *= 10;
                    idx += 3;
                } else {
                    idx += 2;
                }
                d = chrs[idx] - '0';
                if (idx < chrs.length - 1 && Character.isDigit(chrs[idx + 1])) {
                    d *= 10;
                    idx++;
                }
                a = a * d + p * c * b;
                b = d * b;
                int gcd = GCD(a, b);
                a /= gcd;
                b /= gcd;
            }
            idx++;
        }
        return new StringBuilder(String.valueOf(a)).append('/').append(b).toString();
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return GCD(b, a % b);
    }
}
