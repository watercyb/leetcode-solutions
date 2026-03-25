/*
 * Problem: 29. Divide Two Integers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/divide-two-integers/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        int p = 1;
        if (a < 0) {
            a *= -1;
            p = -1;
        }
        if (b < 0) {
            b *= -1;
            p *= -1;
        }
        res = 0;
        div(a, b, 1);
        res *= p;
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) res;
    }

    long res;

    public long div(long a, long b, long n) {
        if (a >= b)
            a = div(a, b + b, n + n);
        while (a >= b) {
            a -= b;
            res += n;
        }
        return a;
    }
}
