/*
 * Problem: 50. Pow(x, n)
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/powx-n/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
        }
        double res = 1;
        while (n != 0) {
            if (n % 2 != 0)
                res *= x;
            n = n / 2;
            x *= x;
        }
        return res;

    }
}
