/*
 * Problem: 371. Sum of Two Integers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-two-integers/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        if (x < y) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        x = Math.abs(a);
        y = Math.abs(b);
        int p = a / x;
        if (a * b > 0) {
            while (y != 0) {
                int tmp = x ^ y;
                y = (x & y) << 1;
                x = tmp;
            }
            return p * x;
        } else {
            while (y != 0) {
                int tmp = x ^ y;
                y = ((~x) & y) << 1;
                x = tmp;
            }
            return p * x;
        }
    }
}
