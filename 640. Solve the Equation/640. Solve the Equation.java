/*
 * Problem: 640. Solve the Equation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/solve-the-equation/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public String solveEquation(String equation) {
        int a = 0;
        int b = 0;
        int pA = 1;
        int pB = -1;
        int p = 1;
        int num = Integer.MIN_VALUE;
        for (char chr : equation.toCharArray()) {
            if (chr == '+') {
                if (num != Integer.MIN_VALUE)
                    b += pB * p * num;
                p = 1;
                num = Integer.MIN_VALUE;
            } else if (chr == '-') {
                if (num != Integer.MIN_VALUE)
                    b += pB * p * num;
                p = -1;
                num = Integer.MIN_VALUE;
            } else if (Character.isDigit(chr)) {
                if (num == Integer.MIN_VALUE)
                    num = 0;
                num = num * 10 + chr - '0';
            } else if (chr == 'x') {
                if (num != Integer.MIN_VALUE) {
                    a += pA * p * num;
                    p = 1;
                    num = Integer.MIN_VALUE;
                } else {
                    a += pA * p;
                    p = 1;
                }
            } else {
                if (num != Integer.MIN_VALUE) {
                    b += pB * p * num;
                    p = 1;
                    num = Integer.MIN_VALUE;
                }
                pA = -1;
                pB = 1;
            }
        }
        if (num != Integer.MIN_VALUE)
            b += pB * p * num;
        if (a == 0) {
            if (b == 0)
                return "Infinite solutions";
            return "No solution";
        }
        return new StringBuilder("x=").append(b / a).toString();
    }
}
